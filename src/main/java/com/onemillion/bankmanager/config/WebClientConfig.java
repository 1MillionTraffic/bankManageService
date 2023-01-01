package com.onemillion.bankmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean("openApiWebClient")
    public WebClient openApiWebClient(OpenApiConfiguration openApiConfiguration) {
        return WebClient.builder()
                .baseUrl(openApiConfiguration.getHost())
                .build();
    }
}
