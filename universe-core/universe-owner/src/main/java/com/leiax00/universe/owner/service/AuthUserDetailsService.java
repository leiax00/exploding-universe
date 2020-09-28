package com.leiax00.universe.owner.service;

import com.leiax00.universe.owner.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.leiax00.universe.common.bean.bo.UserAuthDetail;
import org.leiax00.universe.common.bean.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userDetailsService")
public class AuthUserDetailsService implements UserDetailsService {
    private final UserMapper userMapper;

    @Autowired
    public AuthUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userMapper.findByUsername(userName);
        return userInfo == null ? null : UserAuthDetail.builder()
                .userInfo(userInfo)
                .build();
    }
}
