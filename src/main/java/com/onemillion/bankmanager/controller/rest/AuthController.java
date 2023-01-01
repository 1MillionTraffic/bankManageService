package com.onemillion.bankmanager.controller.rest;

import com.onemillion.bankmanager.service.AuthService;
import com.onemillion.bankmanager.service.OpenApiService;
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
    private final AuthService authService;
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
                              @RequestParam String scope,
                              HttpServletResponse response) throws IOException {

        response.sendRedirect("/");
    }

}
