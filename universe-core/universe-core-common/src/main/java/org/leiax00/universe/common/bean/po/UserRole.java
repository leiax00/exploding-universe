package org.leiax00.universe.common.bean.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
    private int id;

    private String name;

    private String authority;

    private String description;
}
