package com.leiax00.universe.owner.sys.config;

import lombok.Data;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.Duration;

@DubboComponentScan("com.leiax00.universe.owner.service")
@Configuration
@MapperScans({
        @MapperScan("com.leiax00.universe.owner.mapper")
})
@ConfigurationProperties(prefix = "universe.owner")
@Data
public class AppConfig {

    @Value("${auth-refresh:5m}")
    private Duration authRefresh;

    @Value("${auth-timeout:30m}")
    private Duration authTimeout;
}
