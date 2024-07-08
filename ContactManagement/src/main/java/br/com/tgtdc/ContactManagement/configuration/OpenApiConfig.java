package br.com.tgtdc.ContactManagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("bearerAuth",
								new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
								)
						)
				.info(
						new Info()
							.title("Controle de contatos")
							.description("Este app criado para realizar o controle de contatos bem como a criação de pessoas")
							.contact(new Contact()
										.name("Thiago Castro")
										.email("thiagogyorgy.castro@gmail.com")
										.url("https://github.com/ThiCastroo/ControleContatosApp")
										)
							.version("0.0.1-SNAPSHOT")
						)
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
	}
	
}
