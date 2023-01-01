package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.config.OpenApiConfiguration;
import com.onemillion.bankmanager.model.dto.openapi.TokenResponse;
import com.onemillion.bankmanager.model.dto.openapi.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class OpenApiService {

    private final static String LOGIN_PATH = "/oauth/2.0/authorize_account";
    private final static String TOKEN_PATH = "/oauth/2.0/token";
    private final static String USER_ME_PATH = "/v2.0/user/me";

    private final OpenApiConfiguration openApiConfiguration;
    private final WebClient openApiWebClient;

    public String getLoginUrl(HttpServletRequest request) {
        UriComponents uriComponents = getOpenApiUriComponents(LOGIN_PATH)
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", openApiConfiguration.getAuthorizeCallbackUrl())
                .queryParam("scope", "login inquiry")
                .queryParam("state", "b80BLsfigm9OokPTjy03elbJqRHOfGSY") // TODO: CSRF 보안 대응
                .queryParam("auth_type", 0)
                .queryParam("lang", "kor")
                .queryParam("cellphone_cert_yn", "Y")
                .queryParam("authorized_cert_yn", "N")
                .build();

        return uriComponents.toString();
    }

    public TokenResponse getLoginTokenResponse(String code) {
        UriComponents tokenUri = getOpenApiUriComponents(TOKEN_PATH)
                .queryParam("client_secret", openApiConfiguration.getClientSecret())
                .queryParam("redirect_uri", openApiConfiguration.getAuthorizeCallbackUrl())
                .queryParam("grant_type", "authorization_code")
                .queryParam("code", code)
                .build();

        return openApiWebClient.post()
                .uri(tokenUri.toUri())
                .retrieve()
                .bodyToMono(TokenResponse.class)
                .block();
    }

    public UserResponse getUserInfo(TokenResponse tokenResponse) {
        UriComponents userMeUri = getOpenApiUriComponents(USER_ME_PATH)
                .queryParam("user_seq_no", tokenResponse.getUserSeqNo())
                .build();

        return openApiWebClient.get()
                .uri(userMeUri.toUri())
                .header(HttpHeaders.AUTHORIZATION,
                        String.join(" ", tokenResponse.getTokenType(), tokenResponse.getAccessToken()))
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
    }

    private UriComponentsBuilder getOpenApiUriComponents(String path) {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(openApiConfiguration.getHost())
                .path(path)
                .queryParam("client_id", openApiConfiguration.getClientId());
    }
}
