package org.leiax00.universe.owner.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcException;
import org.leiax00.universe.common.bean.exception.UniverseException;
import org.leiax00.universe.common.bean.exception.UniverseRpcException;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.leiax00.universe.owner.api.interf.IUserInfoService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TokenManageService {
    @DubboReference
    private IUserInfoService<UserInfo> service;

    public String generateToken(UserInfo userInfo) {
        try {
            return service.generateToken(userInfo);
        } catch (RpcException e) {
            throw new UniverseRpcException(e);
        }

    }

    public boolean isValidToken(String token) {
        try {
            return service.isValidToken(token);
        } catch (RpcException e) {
            throw new UniverseRpcException(e);
        }
    }

    public UserInfo validateAndReturnUser(String token) {
        try {
            return service.validateAndReturnUser(token);
        } catch (RpcException e) {
            throw new UniverseRpcException(e);
        }
    }

    public void removeToken(String token) {
        service.removeToken(token);
    }
}
