package bean.bo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@PropertySource("classpath:uri-auth-config.yml")
@ConfigurationProperties(prefix = "app")
public class UriAuth {
    private List<UriAuthInfo> authList;
}
