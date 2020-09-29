package org.leiax00.universe.common.client;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.leiax00.universe.common.bean.bo.UriAuth;
import org.leiax00.universe.common.bean.bo.UriAuthInfo;
import org.leiax00.universe.common.bean.common.CommonConst;
import org.leiax00.universe.common.bean.common.ResultCode;
import org.leiax00.universe.common.bean.dto.ResponseRst;
import org.leiax00.universe.common.client.filter.BasicAuthFilter;
import org.leiax00.universe.common.client.filter.CommonLoginFilter;
import org.leiax00.universe.common.client.filter.CommonLogoutHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Configuration
@EnableConfigurationProperties({UriAuth.class})
@ConditionalOnClass(UriAuth.class)
@ComponentScan("org.leiax00.universe.common.spring")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UriAuth uriAuth;
    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UriAuth uriAuth, UserDetailsService userDetailsService) {
        this.uriAuth = uriAuth;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic()
        ;
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();
        List<UriAuthInfo> authList = uriAuth.getAuthList();
        if (authList != null && authList.size() > 0) {
            authList.forEach(item -> {
                if (CommonConst.SYMBOL_PUBLIC.equals(item.getAuth().toUpperCase())) {
                    authorizeRequests.antMatchers(item.getUri()).permitAll();
                } else {
                    authorizeRequests.antMatchers(item.getUri()).hasAuthority(item.getAuth());
                }
            });
        }
        authorizeRequests.anyRequest().authenticated();
        http.logout().logoutUrl("/**/logout").addLogoutHandler(new CommonLogoutHandler())
                .and()
                .addFilter(new CommonLoginFilter(authenticationManager()))
                .addFilter(new BasicAuthFilter(authenticationManager()))
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
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
