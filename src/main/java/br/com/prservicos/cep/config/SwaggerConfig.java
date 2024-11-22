package br.com.prservicos.cep.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi appCepConsult() {
        return GroupedOpenApi.builder()
                .group("cep-api")
                .pathsToMatch("/api/cep/**")
                .build();
    }

}
