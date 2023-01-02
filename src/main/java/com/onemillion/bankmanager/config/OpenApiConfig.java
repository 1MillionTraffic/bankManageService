package com.onemillion.bankmanager.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource("classpath:application-local.yml")
public class OpenApiConfig {
    @Value("${open-api.host}")
    private String host;
    @Value("${open-api.client-id}")
    private String clientId;
    @Value("${open-api.client-secret}")
    private String clientSecret;
    @Value("${open-api.authorize.url}")
    private String authorizeUrl;
    @Value("${open-api.token.url}")
    private String tokenUrl;
    @Value("${open-api.account.url}")
    private String accountUrl;
    @Value("${open-api.user.url}")
    private String userUrl;
}
