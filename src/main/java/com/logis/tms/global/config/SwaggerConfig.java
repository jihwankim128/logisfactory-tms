package com.logis.tms.global.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	private final String devUrl;

	public SwaggerConfig(@Value("${DEV_URL}") String devUrl) {
		this.devUrl = devUrl;
	}

	@Bean
	public OpenAPI openAPI() {
		final Server server = new Server();
		server.setUrl(devUrl);
		server.setDescription("로지스 팩토리 TMS API");

		return new OpenAPI()
			.info(loigsInfo())
			.servers(List.of(server));
	}

	private Info loigsInfo() {
		return new Info()
			.title("Logis Factory")
			.version("v1.0.0")
			.description("로지스 팩토리 API");
	}
}
