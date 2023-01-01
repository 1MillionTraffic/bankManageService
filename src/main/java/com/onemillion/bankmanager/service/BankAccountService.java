package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.model.dto.openapi.BankAccountDTO;
import com.onemillion.bankmanager.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public void syncBankAccount(String userSeqNo, List<BankAccountDTO> bankAccountList) {

    }

    public List<BankAccountDTO> getBankAccount(String userSeqNo) {
        return bankAccountRepository.findAllByUserSeqNo(userSeqNo).stream()
                .map(BankAccountDTO::parse)
                .collect(Collectors.toList());
    }
}
