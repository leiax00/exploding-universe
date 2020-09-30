package org.leiax00.universe.owner.spring.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.leiax00.universe.owner.api.interf.IUserInfoService;
import org.springframework.stereotype.Service;

@Service
public class TokenManageService {
    @DubboReference
    private IUserInfoService<UserInfo> service;

    public String generateToken(UserInfo userInfo) {
        return service.generateToken(userInfo);
    }

    public boolean isValidToken(String token) {
        return service.isValidToken(token);
    }
}
