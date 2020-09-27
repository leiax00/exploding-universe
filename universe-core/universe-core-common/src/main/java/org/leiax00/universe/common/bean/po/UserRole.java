package org.leiax00.universe.common.bean.po;

import lombok.Data;

@Data
public class UserRole {
    private int id;

    private String name;

    private String authority;

    private String description;
}
