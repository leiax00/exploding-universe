package com.leiax00.universe.owner.service;

import com.leiax00.universe.owner.bean.constant.CommonConst;
import com.leiax00.universe.owner.mapper.UserMapper;
import com.leiax00.universe.owner.sys.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.leiax00.universe.owner.api.interf.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@DubboService
@Service
@Slf4j
public class UserService implements IUserInfoService<UserInfo> {
    private final UserMapper userMapper;
    private final RedisTemplate<String, Object> template;
    private final AppConfig config;

    @Autowired
    public UserService(UserMapper userMapper, RedisTemplate<String, Object> template, AppConfig config) {
        this.userMapper = userMapper;
        this.template = template;
        this.config = config;
    }

    public UserInfo findByUsername(String userName) throws UsernameNotFoundException {
        return userMapper.findByUsername(userName);
    }

    @Override
    public String generateToken(UserInfo userInfo) {
        String token;
        String key;
        while (true) {
            token = UUID.randomUUID().toString().replace("-", "");
            key = CommonConst.getRedisKey4UserByToken(token);
            Boolean hasKey = this.template.hasKey(key);
            if (hasKey == null || !hasKey) {
                break;
            }
        }
        this.template.opsForValue().set(key, userInfo, config.getAuthTimeout().toMillis(), TimeUnit.MILLISECONDS);
        return token;
    }

    @Override
    public boolean isValidToken(String token) {
        String key = CommonConst.getRedisKey4UserByToken(token);
        Long expire = this.template.getExpire(key, TimeUnit.MILLISECONDS);
        if (expire != null && expire > 0) {
            if (config.getAuthTimeout().toMillis() - expire > config.getAuthRefresh().toMillis()) {
                this.template.expire(key, config.getAuthTimeout().toMillis(), TimeUnit.MILLISECONDS);
            }
            return true;
        }
        return false;
    }

    @Override
    public UserInfo validateAndReturnUser(String token) {
        String key = CommonConst.getRedisKey4UserByToken(token);
        Object obj = this.template.opsForValue().get(key);
        if (obj == null) {
            return null;
        }
        Long expire = this.template.getExpire(key, TimeUnit.MILLISECONDS);
        if (expire != null && (config.getAuthTimeout().toMillis() - expire > config.getAuthRefresh().toMillis())) {
            this.template.expire(key, config.getAuthTimeout().toMillis(), TimeUnit.MILLISECONDS);
        }
        return (UserInfo) obj;
    }

    @Override
    public void removeToken(String token) {
        this.template.delete(CommonConst.getRedisKey4UserByToken(token));
    }
}
