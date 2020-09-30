package org.leiax00.universe.owner.client.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.leiax00.universe.common.bean.common.CommonConst;
import org.leiax00.universe.common.bean.common.ResultCode;
import org.leiax00.universe.common.bean.dto.ResponseRst;
import org.leiax00.universe.common.bean.exception.UniverseRpcException;
import org.leiax00.universe.owner.spring.service.TokenManageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CommonLogoutHandler implements LogoutHandler {
    private TokenManageService tokenService;

    public CommonLogoutHandler(TokenManageService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String token = request.getHeader(CommonConst.HEADER_AUTH);
        if (token != null) {
            try {
                tokenService.removeToken(token);
                this.writeMsg(response, ResultCode.STATUS_SUCCESS);
            } catch (UniverseRpcException e) {
                log.error("failed to request remote service, err:", e);
                this.writeMsg(response, ResultCode.STATUS_RPC_EXCEPTION);
            }
        }
    }

    private void writeMsg(HttpServletResponse response, ResultCode code) {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            JSON.writeJSONString(response.getWriter(), ResponseRst.build().with(code.getCode(), code.messageKey()));
        } catch (IOException e) {
            log.error("System Exception: Can not get response writer:", e);
        }
    }
}
