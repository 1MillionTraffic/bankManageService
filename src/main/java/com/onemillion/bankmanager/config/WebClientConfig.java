package com.onemillion.bankmanager.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Slf4j
public class WebClientConfig {

    @Bean("openApiWebClient")
    public WebClient openApiWebClient(OpenApiConfiguration openApiConfiguration, ObjectMapper objectMapper) {
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer ->
                        configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper)))
                .build();

        return WebClient.builder()
                .baseUrl(openApiConfiguration.getHost())
                .exchangeStrategies(exchangeStrategies)
                .build();
    }
}
