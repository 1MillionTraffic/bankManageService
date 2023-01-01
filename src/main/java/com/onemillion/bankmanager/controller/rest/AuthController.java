package com.onemillion.bankmanager.controller.rest;

import com.onemillion.bankmanager.model.dto.openapi.TokenResponse;
import com.onemillion.bankmanager.model.dto.openapi.UserResponse;
import com.onemillion.bankmanager.service.AccountService;
import com.onemillion.bankmanager.service.AuthService;
import com.onemillion.bankmanager.service.OpenApiService;
import com.onemillion.bankmanager.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AccountService accountService;
    private final AuthService authService;
    private final TokenService tokenService;
    private final OpenApiService openApiService;

    @GetMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String loginUrl = openApiService.getLoginUrl(request);
        response.sendRedirect(loginUrl);
    }

    @GetMapping("/callback")
    public void oauthCallback(@RequestParam(value = "client_info", required = false) String clientInfo,
                              @RequestParam String code,
                              @RequestParam String state,
                              HttpServletResponse response) throws Exception {

        // TODO: csrf 검증

        // code -> token 변환
        TokenResponse tokenResponse = openApiService.getLoginTokenResponse(code);

        // token -> get resource
        UserResponse userResponse = openApiService.getUserInfo(tokenResponse);
        // save resource
        authService.syncUser(userResponse);
        accountService.syncBankAccount(userResponse.getBankAccountList());

        // token -> encrypt and set cookie
        tokenService.setAccessToken(response, tokenResponse.getAccessToken());
        tokenService.setRefreshToken(response, tokenResponse.getRefreshToken());

        response.sendRedirect("/");
    }

}
