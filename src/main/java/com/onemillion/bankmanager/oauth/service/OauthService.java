package com.onemillion.bankmanager.oauth.service;


import com.onemillion.bankmanager.config.OpenApiConfig;
import com.onemillion.bankmanager.config.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class OauthService {
    private final OpenApiConfig openApiConfig;
    private final WebClient webClient;

    @Autowired
    public OauthService(OpenApiConfig openApiConfig, WebClient webClient) {
        this.openApiConfig = openApiConfig;
        this.webClient = webClient;
    }

    public void info(){
        System.out.println(openApiConfig.getHost());
        System.out.println(openApiConfig.getClientId());
        System.out.println(openApiConfig.getClientSecret());
        System.out.println(openApiConfig.getTokenUrl());
        System.out.println(openApiConfig.getAuthorizeUrl());
    }

    public void getToken(String code){
        Map<String, String> request = new HashMap<>();
        request.put("code", code);
        request.put("client_id", openApiConfig.getClientId());
        request.put("client_secret", "e1c71fce-5811-43dd-b70a-139f3b59f28d");
        request.put("redirect_uri", URL.AUTHORIZE_CALLBACK_URL.getValue());
        request.put("grant_type", "authorization_code");
        System.out.println("request: "+request);
        Map<String, String> response = new HashMap<>();
        response.put("access_token", null);
        response.put("token_type", null);
        response.put("expires_in", null);
        response.put("refresh_token", null);
        response.put("scope", null);
        response.put("user_seq_no", null);
        response = WebClient.create().post()
//                .uri("https://openapi.openbanking.or.kr/oauth/2.0/token")
                .uri(openApiConfig.getHost()+openApiConfig.getTokenUrl())
                .body(Mono.just(request), request.getClass())
                .retrieve()
                .bodyToMono(response.getClass())
                .block();
        System.out.println("response " + response);
        String accessToken = response.get("access_token");
        System.out.println("accessToken: "+accessToken);
        System.out.println("refreshToken: "+response.get("refresh_token"));
    }
}
