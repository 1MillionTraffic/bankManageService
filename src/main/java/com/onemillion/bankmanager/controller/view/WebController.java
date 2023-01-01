package com.onemillion.bankmanager.controller.view;

import com.onemillion.bankmanager.interfaces.ParseAuth;
import com.onemillion.bankmanager.model.dto.AuthResult;
import com.onemillion.bankmanager.model.dto.openapi.BankAccountDTO;
import com.onemillion.bankmanager.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class WebController {
    private final BankAccountService bankAccountService;

    @GetMapping
    public String mainPage(Model model, @ParseAuth(required = false) AuthResult authResult) {

        // if login -> 계좌 목록 조회
        if(authResult.isLogin()) {
            List<BankAccountDTO> bankAccountList = bankAccountService.getBankAccount(authResult.getUser().getUserSeqNo());
            model.addAttribute("bankAccountList", bankAccountList);
        }

        model.addAttribute("isLogin", authResult.isLogin());
        return "main";
    }

}
