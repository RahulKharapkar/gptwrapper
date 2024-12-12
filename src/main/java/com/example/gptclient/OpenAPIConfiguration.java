package com.example.gptclient;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.BooleanSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Access Swagger spec at http://localhost:8080/swagger-ui/index.html#/

@Configuration
public class OpenAPIConfiguration {

	@Value("${project.version}")
	private String projectVersion;

	@Bean
	public OpenAPI expenseAPI() {
		return new OpenAPI()
				.info(new Info().title("GPT Wrapper API")
						.description("Gpt Wrapper is a ChatGPT integration API for automating tasks, handling conversational data, and leveraging AI capabilities within applications.")
						.version(projectVersion)
						 .contact(new Contact().name("Rahul Kharapkar")
								 .email("rahul.p.kharapkar@gmail.com")
								 .url("http://geekon99.wordpress.com")));
	}

}