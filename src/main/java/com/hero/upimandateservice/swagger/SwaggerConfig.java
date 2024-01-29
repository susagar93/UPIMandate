package com.hero.upimandateservice.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("UPI Mandate API")
                        .description("This is UPI Mandate API ::  UPI Autopay Mandate")
                        .version("1.0")
                        .contact(new Contact().name("HERO FIN CORP LTD"))
                        .license(new License().name("Apache")))
                .externalDocs(new ExternalDocumentation().description("").url(""));


    }
}
