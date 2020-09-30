package org.leiax00.universe.owner.client.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.rpc.RpcException;
import org.leiax00.universe.common.bean.common.ResultCode;
import org.leiax00.universe.common.bean.dto.ResponseRst;
import org.leiax00.universe.owner.api.bean.dto.SimpleUser;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.leiax00.universe.owner.client.bean.bo.UserAuthDetail;
import org.leiax00.universe.owner.client.dto.AuthUserResp;
import org.leiax00.universe.owner.spring.service.TokenManageService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CommonLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private TokenManageService userDetailsService;

    public CommonLoginFilter(AuthenticationManager authenticationManager, TokenManageService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.setPostOnly(false);
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/login"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.info("start to auth login info.");
        try {
            SimpleUser user;
            if (HttpMethod.POST.name().equals(request.getMethod())) {
                user = JSON.parseObject(request.getInputStream(), SimpleUser.class);
            } else {
                user = SimpleUser.builder().username(request.getParameter("username")).password(request.getParameter("password")).build();
            }
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        UserInfo userInfo = ((UserAuthDetail) (authResult.getPrincipal())).getUserInfo();
        try {
            String token = this.userDetailsService.generateToken(userInfo);
            JSONObject.writeJSONString(response.getWriter(), ResponseRst.builder()
                    .data(new AuthUserResp().fillBy(token, userInfo))
                    .build().withOk()
            );
        } catch (RpcException e) {
            logger.error("failed to request remote service, err:", e);
            JSONObject.writeJSONString(response.getWriter(), ResponseRst.builder()
                    .build().withError(ResultCode.STATUS_RPC_EXCEPTION));
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ResponseRst<Object> rst = ResponseRst.builder()
                .build().withData(failed.getMessage());
        Throwable cause = failed.getCause();
        if (cause instanceof RpcException) {
            rst.withError(ResultCode.STATUS_RPC_EXCEPTION);
        } else {
            rst.withError(ResultCode.STATUS_INVALID_AUTH_INFO);
        }
        JSONObject.writeJSONString(response.getWriter(), rst);
    }
}
