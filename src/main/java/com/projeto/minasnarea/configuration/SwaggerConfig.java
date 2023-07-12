package com.projeto.minasnarea.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
	@Bean
	OpenAPI springMinasnaAreaOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Projeto Minas na Área").description("Projeto Minas na Área - Generation Brasil")
						.version("v0.0.1")
						.license(new License().name("Generation Brasil").url("https://brazil.generation.org/"))
						.contact(new Contact().name("PI-G04").url("https://github.com/PI-G04/backend")
								.email("conteudodogeneration@generation.org")))
				.externalDocs(new ExternalDocumentation().description("Github")
						.url("https://github.com/PI-G04/backend"));

	}
	@Bean
	OpenApiCustomizer customizerGlobalHeaderOpenApiCustomizer () {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation  -> {
			
				ApiResponses apiResponses = operation.getResponses();
				
				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluido!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso não Autorizado!"));
				apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Sucesso!"));
			}));
		};
	}
	private ApiResponse createApiResponse(String message) {
		return new ApiResponse().description(message);
	}
}