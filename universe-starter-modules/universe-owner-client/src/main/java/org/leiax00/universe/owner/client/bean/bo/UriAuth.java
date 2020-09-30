package org.leiax00.universe.owner.client.bean.bo;

import lombok.Data;
import org.leiax00.universe.owner.api.bean.bo.UriAuthInfo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@PropertySource("classpath:uri-auth-config.yml")
@ConfigurationProperties(prefix = "app")
public class UriAuth {
    private List<UriAuthInfo> authList;
}
