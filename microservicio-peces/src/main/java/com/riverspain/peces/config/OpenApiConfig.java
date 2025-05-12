package com.riverspain.peces.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI pecesAPI() {
		return new OpenAPI()
				.info(new Info().title("API de peces de RiverSpain")
						.description("Rest Api de peces")
						.version("v0.1"));
				
	}
}
