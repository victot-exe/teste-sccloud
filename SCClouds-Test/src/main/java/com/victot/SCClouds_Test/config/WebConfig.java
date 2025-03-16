package com.victot.SCClouds_Test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir CORS para todas as URLs com qualquer origem
        registry.addMapping("/**") // Permite para todas as rotas
                .allowedOrigins("http://127.0.0.1:5500")  // Permite apenas a origem específica (pode adicionar outras se necessário)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*"); // Cabeçalhos permitidos
    }
}
