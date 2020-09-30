package org.leiax00.universe.owner.client.dto;

import lombok.Data;
import org.leiax00.universe.owner.api.bean.po.UserInfo;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class AuthUserResp {
    private String username;

    private String roleName;

    private Set<String> authorities;

    private String token;

    public AuthUserResp fillBy(String token, UserInfo userInfo) {
        this.username = userInfo.getUsername();
        this.roleName = userInfo.getRole().getName();
        this.authorities = Stream.of(userInfo.getRole().getAuthority().split(",")).collect(Collectors.toSet());
        this.token = token;
        return this;
    }
}
