package org.leiax00.universe.owner.api.bean.po;

import lombok.Data;
import org.leiax00.universe.owner.api.bean.po.UserRole;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private int id;

    private String username;

    private String password;

    private UserRole role;

    private String phoneNumber;

    private int status;

    private String description;
}
