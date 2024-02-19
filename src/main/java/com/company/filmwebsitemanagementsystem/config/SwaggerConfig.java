package com.company.filmwebsitemanagementsystem.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Open API",
        description = "Open API description",
        version = "1.0.0",
        contact = @Contact(
                name = "yusifhashimov",
                email = "yusifhashimov10@gmail.com",
                url = "yusifhashimov.com")))
public class SwaggerConfig {
}
