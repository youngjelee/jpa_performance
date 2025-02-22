package com.allmytour.ai.core.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

//        String key = "Access Token (Bearer)";
//        String refreshKey = "Refresh Token";
//
//        SecurityRequirement securityRequirement = new SecurityRequirement()
//                .addList(key)
//                .addList(refreshKey);
//
//        SecurityScheme accessTokenSecurityScheme = new SecurityScheme()
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("Bearer")
//                .bearerFormat("JWT")
//                .in(SecurityScheme.In.HEADER)
//                .name(HttpHeaders.AUTHORIZATION);
//
//        SecurityScheme refreshTokenSecurityScheme = new SecurityScheme()
//                .type(SecurityScheme.Type.APIKEY)
//                .in(SecurityScheme.In.COOKIE)
//                .name("refresh");
//
//        Components components = new Components()
//                .addSecuritySchemes(key, accessTokenSecurityScheme)
//                .addSecuritySchemes(refreshKey, refreshTokenSecurityScheme);

        return new OpenAPI()
                .info(new Info()
                        .title("gpt 연동 project")
                        .version("1.0.0"));
//                .addSecurityItem(securityRequirement)
//                .components(components);



    }
}