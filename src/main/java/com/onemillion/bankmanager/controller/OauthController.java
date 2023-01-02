package com.onemillion.bankmanager.controller;

import com.onemillion.bankmanager.dto.response.TokenResponseDto;
import com.onemillion.bankmanager.service.OauthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/oauth")
@Controller
public class OauthController {
    private final OauthService oauthService;

    @Autowired
    public OauthController(OauthService oauthService) {
        this.oauthService = oauthService;
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
        System.out.println("authorizeCallback?");
        System.out.println("code: "+code);
        TokenResponseDto token = oauthService.getToken(code);
        System.out.println(token);
        response.sendRedirect("/home");
    }
}
