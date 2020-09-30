package org.leiax00.universe.owner.client.filter;

import com.alibaba.fastjson.JSON;
import org.apache.dubbo.rpc.RpcException;
import org.leiax00.universe.common.bean.common.CommonConst;
import org.leiax00.universe.common.bean.common.ResultCode;
import org.leiax00.universe.common.bean.dto.ResponseRst;
import org.leiax00.universe.common.bean.exception.UniverseException;
import org.leiax00.universe.common.bean.exception.UniverseRpcException;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.leiax00.universe.owner.spring.service.TokenManageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BasicAuthFilter extends BasicAuthenticationFilter {
    private TokenManageService tokenManageService;

    public BasicAuthFilter(AuthenticationManager authenticationManager, TokenManageService tokenService) {
        super(authenticationManager);
        this.tokenManageService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(CommonConst.HEADER_AUTH);
        if (StringUtils.isEmpty(token)) {
            JSON.writeJSONString(response.getWriter(), ResponseRst.build().withError(ResultCode.STATUS_WITHOUT_AUTH_INFO));
            return;
        }
        UserInfo userInfo;
        try {
            userInfo = tokenManageService.validateAndReturnUser(token);
            if (userInfo == null) {
                this.writeFailedMsg(response, ResultCode.STATUS_INVALID_AUTH_INFO);
                return;
            }
        } catch (UniverseRpcException e) {
            logger.error("failed to request remote service:", e);
            this.writeFailedMsg(response, e.getCode());
            return;
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userInfo, token, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private void writeFailedMsg(HttpServletResponse response, ResultCode code) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        JSON.writeJSONString(response.getWriter(), ResponseRst.build().withError(code));
    }
}
