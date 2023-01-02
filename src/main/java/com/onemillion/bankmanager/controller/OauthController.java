package com.onemillion.bankmanager.controller;

import com.onemillion.bankmanager.dto.response.TokenResponseDto;
import com.onemillion.bankmanager.dto.response.UserResponseDto;
import com.onemillion.bankmanager.entity.Token;
import com.onemillion.bankmanager.service.OauthService;
import com.onemillion.bankmanager.service.TokenService;
import com.onemillion.bankmanager.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/oauth")
@Controller
public class OauthController {
    private final OauthService oauthService;
    private final TokenService tokenService;
    private final UserService userService;

    @Autowired
    public OauthController(OauthService oauthService, TokenService tokenService, UserService userService) {
        this.oauthService = oauthService;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect(oauthService.getLoginUri());
    }


    @GetMapping("/callback")
    public void authorizeCallback(
            @RequestParam String code,
            @RequestParam String scope,
            @RequestParam(value = "client_info", required = false) String client_info,
            @RequestParam String state,
            HttpServletResponse response
    ) throws IOException {
        TokenResponseDto token = oauthService.getToken(code);
        Token savedToken = tokenService.save(token);
        UserResponseDto user = oauthService.getUser(token);
        System.out.println(user);
        response.sendRedirect("/home");
    }
}
