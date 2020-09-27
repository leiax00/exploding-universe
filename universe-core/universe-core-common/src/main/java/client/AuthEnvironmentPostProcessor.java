package client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Slf4j
public class AuthEnvironmentPostProcessor implements EnvironmentPostProcessor {
    private final ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    private final YamlPropertySourceLoader loader = new YamlPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            Resource[] resources = this.resolver.getResources(ResourceUtils.CLASSPATH_URL_PREFIX + File.separator + "*auth-config.yml");
            for (Resource resource : resources) {
                loader.load(resource.getFilename(), resource).forEach(environment.getPropertySources()::addLast);
            }
        } catch (IOException e) {
            log.error("failed to load auth config.", e);
        }


    }
}
