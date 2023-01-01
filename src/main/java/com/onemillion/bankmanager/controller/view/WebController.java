package com.onemillion.bankmanager.controller.view;

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
    public String mainPage(Model model) {
        model.addAttribute("isLogin", false);
        return "main";
    }

}
