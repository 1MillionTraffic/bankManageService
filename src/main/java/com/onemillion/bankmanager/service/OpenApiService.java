package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.config.OpenApiConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class OpenApiService {
    private final OpenApiConfiguration openApiConfiguration;
    private final static String loginPath = "/oauth/2.0/authorize_account";

    public String getLoginUrl(HttpServletRequest request) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(openApiConfiguration.getHost())
                .path(loginPath)
                .queryParam("response_type", "code")
                .queryParam("client_id", openApiConfiguration.getClientId())
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
}
