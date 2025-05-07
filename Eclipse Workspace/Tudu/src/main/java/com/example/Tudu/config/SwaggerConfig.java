package com.example.Tudu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;

@Configuration
@SecurityScheme(
			name = "bearerAuth",
			type = SecuritySchemeType.HTTP,
			bearerFormat = "JWT",
			scheme = "bearer"
)
public class SwaggerConfig {
	@Bean
	public OpenAPI customOpenAPI() {
	    return new OpenAPI()
	            .info(new Info()
	                    .title("Tudu Web App")
	                    .version("1.0")
	                    .description("API documentation for tudu"))
	            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
	}


}
