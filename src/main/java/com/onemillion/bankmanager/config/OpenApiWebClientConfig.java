package com.onemillion.bankmanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OpenApiWebClientConfig {
    @Value("${open-api.host}")
    private String openApiUrl;

    @Bean
    public WebClient openApiWebClient() {
        return WebClient.builder()
                .baseUrl(openApiUrl)
                .build();
    }
}
