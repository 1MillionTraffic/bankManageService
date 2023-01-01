package com.onemillion.bankmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(OpenApiConfig openApiConfig){
        return WebClient.builder()
                .baseUrl(openApiConfig.getHost())
                .build();
    }
}
