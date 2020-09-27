package org.leiax00.universe.common.bean.po;

import lombok.Data;

@Data
public class UserInfo {
    private int id;

    private String username;

    private String password;

    private UserRole role;

    private String phoneNumber;

    private int status;

    private String description;
}
