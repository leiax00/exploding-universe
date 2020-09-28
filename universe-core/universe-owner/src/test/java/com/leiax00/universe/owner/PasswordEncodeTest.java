package com.leiax00.universe.owner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:uri-auth-config.yml")
class PasswordEncodeTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void passwordEncoder() {
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("root"));
        System.out.println(passwordEncoder.encode("wewins"));
        System.out.println(passwordEncoder.encode("lax4832."));
    }
}
