package com.tenant.resolver;

import org.springframework.boot.SpringApplication;

public class TestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(ResolverApplication::main)
                .with(TestContainerConfig.class)
                .run(args);
    }
}
