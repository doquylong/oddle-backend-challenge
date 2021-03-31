package com.oddle.app.weather.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        List<Server> server = new ArrayList<>();
        server.add(new Server().url("http://localhost:8080"));
        return new OpenAPI()
                .servers(server)
                .info(new Info().title("Do Qui Long - Weather API")
                        .description("Weather Management API")
                        .contact(new Contact()
                                .email("quylongqn98@gmail.com")
                                .name("longdq"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .version("1.0.0"));
    }
}
