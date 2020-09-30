package org.leiax00.universe.owner.api.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SimpleUser {
    private String username;

    private String password;
}
