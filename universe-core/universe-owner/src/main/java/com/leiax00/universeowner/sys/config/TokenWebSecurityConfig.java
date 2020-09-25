package com.leiax00.universeowner.sys.config;

import bean.bo.ResultCode;
import bean.dto.ResponseRst;
import com.alibaba.fastjson.JSON;
import com.leiax00.universeowner.sys.filter.TokenAuthenticationFilter;
import com.leiax00.universeowner.sys.filter.TokenLoginFilter;
import com.leiax00.universeowner.sys.filter.TokenLogoutHandler;
import com.leiax00.universeowner.sys.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    @Autowired
    public TokenWebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/**/login", "/**/public/**", "/version/**")
                .permitAll().anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/**/logout").addLogoutHandler(new LogoutHandler)
                .and()
                .addFilter(new TokenLoginFilter(authenticationManager(), tokenManager))
                .addFilter(new TokenAuthenticationFilter(authenticationManager(), tokenManager))
                .httpBasic();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static class UnauthorizedEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            JSON.writeJSONString(response.getWriter(), ResponseRst.builder().build()
                    .withError(ResultCode.STATUS_UNAUTHORIZED)
            );
        }
    }
}
