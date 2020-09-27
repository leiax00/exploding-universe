package org.leiax00.universe.common.spring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public interface TokenUserDetailsService extends UserDetailsService {
    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
}
