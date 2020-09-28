package com.leiax00.universe.owner.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 应用初始化动作
 */

@Component
@Order(1)
public class StartRunner implements CommandLineRunner {

    @Autowired
    public StartRunner() {
    }

    @Override
    public void run(String... args) {

    }
}
