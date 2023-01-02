package com.onemillion.bankmanager.controller;

import com.onemillion.bankmanager.dto.AuthUser;
import com.onemillion.bankmanager.dto.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class HomeController {
    @GetMapping
    public String home(Model model){
        model.addAttribute("isLogin", false);
        return "home";
    }
}
