package com.kotonoha.review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable()) // tắt CSRF để cho phép POST từ frontend
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/reviews/**").permitAll() // cho phép GET + POST không cần login
                        .anyRequest().permitAll() // cho phép tất cả request khác luôn (tạm thời để test)
                );

        return http.build();
    }
}
