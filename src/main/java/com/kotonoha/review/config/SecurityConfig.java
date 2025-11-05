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
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()   // ✅ Mở toàn bộ API
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form.disable())            // ✅ Tắt login page
                .httpBasic(httpBasic -> httpBasic.disable()); // ✅ Tắt Basic Auth

        return http.build();
    }
}
