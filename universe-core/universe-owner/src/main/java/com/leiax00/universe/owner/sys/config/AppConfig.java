package com.leiax00.universe.owner.sys.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScans({
        @MapperScan("com.leiax00.universe.owner.mapper")
})
public class AppConfig {
}
