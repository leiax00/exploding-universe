
package org.leiax00.universe.owner.spring.service;

import org.leiax00.universe.owner.api.interf.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.leiax00.universe.owner.client.bean.bo.UserAuthDetail;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userDetailsService")
public class AuthUserDetailsService implements UserDetailsService {
    @DubboReference
    private IUserInfoService<UserInfo> service;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = service.findByUsername(userName);
        return userInfo == null ? null : UserAuthDetail.builder()
                .userInfo(userInfo)
                .build();
    }
}
