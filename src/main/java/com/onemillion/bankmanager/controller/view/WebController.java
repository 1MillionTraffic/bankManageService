package com.onemillion.bankmanager.controller.view;

import com.onemillion.bankmanager.interfaces.ParseAuth;
import com.onemillion.bankmanager.model.dto.AuthResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class WebController {

    @GetMapping
    public String mainPage(Model model, @ParseAuth(required = false) AuthResult authResult) {
        model.addAttribute("isLogin", authResult.isLogin());
        return "main";
    }

}
