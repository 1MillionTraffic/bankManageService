package com.onemillion.bankmanager.oauth.api;

import com.onemillion.bankmanager.oauth.service.OauthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/oauth")
@RestController
public class OauthApiController {
    private final OauthService oauthService;

    @Autowired
    public OauthApiController(OauthService oauthService) {
        this.oauthService = oauthService;
    }


    @GetMapping("/callback")
    public void authorizeCallback(
            @RequestParam String code,
            @RequestParam String scope,
            @RequestParam(value = "client_info", required = false) String client_info,
            @RequestParam String state
    ){
        System.out.println("authorizeCallback?");
        System.out.println("code: "+code);
        // token 발급 구현
        oauthService.getToken(code);
        //
    }

    @GetMapping("/info")
    public void info(){
        oauthService.info();
    }
    @PostMapping("/token")
    public void getToken(@RequestParam String code){
        oauthService.getToken(code);
    }
}
