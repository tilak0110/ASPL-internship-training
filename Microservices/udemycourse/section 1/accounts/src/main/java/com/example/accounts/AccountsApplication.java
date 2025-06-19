package com.example.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts Microservice API Documentation",
				description = "DummyBank MicroService API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Tilak Raj Sahu",
						email = "tilakraj.sahu9406@gmail.com",
						url = "https://tilakrajsahu.com"
				),
				license = @License(
						name = "FarziLicense",
						url = "http://idontwanttoshow.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "FakeBank Accounts microservice REST API Documentation",
				url = "https://localhost:8080/swagger-ui.html"
		)
)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AccountsApplication {

	public static void main(String[] args) {
			SpringApplication.run(AccountsApplication.class, args);
	}

}
