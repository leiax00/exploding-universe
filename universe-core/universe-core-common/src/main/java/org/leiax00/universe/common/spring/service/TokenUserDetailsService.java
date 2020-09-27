package org.leiax00.universe.common.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.leiax00.universe.common.bean.bo.UserAuthDetail;
import org.leiax00.universe.common.bean.po.UserInfo;
import org.leiax00.universe.common.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@Slf4j
public class TokenUserDetailsService implements UserDetailsService {
    private final UserMapper userMapper;

    @Autowired
    public TokenUserDetailsService(UserMapper userMapper) {
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
