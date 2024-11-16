package com.score.apirouting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // Configurar los orígenes permitidos
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:3000","https://lenovospadline.score.net.co"));

        // Configurar los encabezados permitidos
        corsConfiguration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "X-Requested-With"));

        // Configurar los métodos permitidos
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Permitir el envío de credenciales (cookies, headers de autenticación, etc.)
        corsConfiguration.setAllowCredentials(true);

        // Configurar la fuente de las configuraciones CORS
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        // Devolver el filtro CORS configurado
        return new CorsWebFilter(source);
    }
}
