package com.dsaoDev.peopleAPI.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("People-API")
				.pathsToMatch("/**")
				.build();
		
	}
	

	@Bean
	public OpenAPI daviAPI() {
		return new OpenAPI()
				.info(new Info().title("PEOPLE-API")
						.description("Projeto para Estudos")
						.version("v0.0.1")
						.license(new License().name("Spring Doc").url("https://springdoc.org")));
				
	}
}
