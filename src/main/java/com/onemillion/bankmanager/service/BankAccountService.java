package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.model.dto.openapi.BankAccountDTO;
import com.onemillion.bankmanager.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public void syncBankAccount(String userSeqNo, List<BankAccountDTO> bankAccountList) {

    }

    public List<BankAccountDTO> getBankAccount(String userSeqNo) {
        return Collections.emptyList();
    }
}
