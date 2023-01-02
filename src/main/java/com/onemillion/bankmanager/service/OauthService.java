package com.onemillion.bankmanager.service;


import com.onemillion.bankmanager.config.OpenApiConfig;
import com.onemillion.bankmanager.config.URL;
import com.onemillion.bankmanager.dto.response.TokenResponseDto;
import com.onemillion.bankmanager.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class OauthService {
    private final OpenApiConfig openApiConfig;
    private final WebClient webClient;

    @Autowired
    public OauthService(OpenApiConfig openApiConfig, WebClient webClient) {
        this.openApiConfig = openApiConfig;
        this.webClient = webClient;
    }

    public String getLoginUri(){
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(openApiConfig.getHost())
                .path(openApiConfig.getAccountUrl())
                .queryParam("response_type", "code")
                .queryParam("client_id", openApiConfig.getClientId())
                .queryParam("redirect_uri", URL.AUTHORIZE_CALLBACK_URL.getValue())
                .queryParam("scope", "login inquiry transfer")
                .queryParam("state", "12345678901234567890123456789012")
                .queryParam("auth_type", "0")
                .toUriString();
    }

    public TokenResponseDto getToken(String code){
        return webClient.post()
                .uri(getTokenUri(code))
                .retrieve()
                .bodyToMono(TokenResponseDto.class)
                .block();
    }

    private URI getTokenUri(String code) {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(openApiConfig.getHost())
                .path(openApiConfig.getTokenUrl())
                .queryParam("client_id", openApiConfig.getClientId())
                .queryParam("client_secret", openApiConfig.getClientSecret())
                .queryParam("redirect_uri", URL.AUTHORIZE_CALLBACK_URL.getValue())
                .queryParam("grant_type", "authorization_code")
                .queryParam("code", code)
                .build()
                .toUri();
    }

    public UserResponseDto getUser(TokenResponseDto token){
        return webClient.get()
                .uri(getUserUri(token))
                .header("Authorization", "Bearer "+token.getAccessToken())
                .retrieve()
                .bodyToMono(UserResponseDto.class)
                .block();
    }

    private URI getUserUri(TokenResponseDto token){
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(openApiConfig.getHost())
                .path(openApiConfig.getUserUrl())
                .queryParam("client_id", openApiConfig.getClientId())
                .queryParam("user_seq_no", token.getUserSeqNo())
                .build()
                .toUri();
    }
}
