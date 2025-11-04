package com.kotonoha.review.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {
  @Value("${app.cors.allowed-origins:*}")
  private String allowed;

  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration cors = new CorsConfiguration();
    if ("*".equals(allowed)) {
      cors.addAllowedOriginPattern("*");
    } else {
      for (String o : allowed.split(",")) cors.addAllowedOrigin(o.trim());
    }
    cors.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
    cors.setAllowedHeaders(List.of("*"));
    cors.setAllowCredentials(false);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", cors);
    return new CorsFilter(source);
  }
}
