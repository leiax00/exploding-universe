package com.leiax00.universe.owner.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.leiax00.universe.owner.mapper.UserMapper;
import interf.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.leiax00.universe.common.bean.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Slf4j
public class UserDubboService implements IUserInfoService<UserInfo> {
    private final UserMapper userMapper;

    @Autowired
    public UserDubboService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserInfo findByUsername(String userName) throws UsernameNotFoundException {
        return userMapper.findByUsername(userName);
    }

    @Override
    public String generateToken(UserInfo userInfo) {
        return null;
    }

    @Override
    public boolean isValidToken(String token) {
        return false;
    }

}
