package org.example.expert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.expert.config")
public class JwtConfig {
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}
