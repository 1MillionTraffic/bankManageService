package com.onemillion.bankmanager.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("open-api")
public class OpenApiConfiguration {
    private String clientId;
    private String clientSecret;
    private String host;
    private String authorizeCallbackUrl;
}
