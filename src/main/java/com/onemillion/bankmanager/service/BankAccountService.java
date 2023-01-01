package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.model.dto.openapi.BankAccountDTO;
import com.onemillion.bankmanager.model.entity.BankAccount;
import com.onemillion.bankmanager.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public void syncBankAccount(String userSeqNo, List<BankAccountDTO> bankAccountDTOList) {
        bankAccountDTOList.forEach(bankAccountDTO -> upsertBankAccount(userSeqNo, bankAccountDTO));
    }

    public List<BankAccountDTO> getBankAccount(String userSeqNo) {
        return bankAccountRepository.findAllByUserSeqNo(userSeqNo).stream()
                .map(BankAccountDTO::parse)
                .toList();
    }

    private void upsertBankAccount(String userSeqNo, BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountRepository.findByFintechUseNum(bankAccountDTO.getFintechUseNum());

        if(Objects.isNull(bankAccount)) {
            bankAccount = new BankAccount();
            bankAccount.setUserSeqNo(userSeqNo);
            bankAccount.setFintechUseNum(bankAccountDTO.getFintechUseNum());
            bankAccount.setAccountAlias(bankAccountDTO.getAccountAlias());
            bankAccount.setBankCodeStd(bankAccountDTO.getBankCodeStd());
            bankAccount.setBankCodeSub(bankAccountDTO.getBankCodeSub());
            bankAccount.setBankName(bankAccountDTO.getBankName());
            bankAccount.setSavingsBankName(bankAccountDTO.getSavingsBankName());
            bankAccount.setAccountNumMasked(bankAccountDTO.getAccountNumMasked());
            bankAccount.setAccountSeq(bankAccountDTO.getAccountSeq());
            bankAccount.setAccountHolderName(bankAccountDTO.getAccountHolderName());
            bankAccount.setAccountHolderType(bankAccountDTO.getAccountHolderType());
            bankAccount.setAccountType(bankAccountDTO.getAccountType());
            bankAccount.setPayerNum(bankAccountDTO.getPayerNum());
        }

        bankAccount.setInquiryAgreeYn(bankAccountDTO.getInquiryAgreeYn());
        bankAccount.setInquiryAgreeDtime(bankAccountDTO.getInquiryAgreeDtime());
        bankAccount.setTransferAgreeYn(bankAccountDTO.getTransferAgreeYn());
        bankAccount.setTransferAgreeDtime(bankAccountDTO.getTransferAgreeDtime());
        bankAccount.setUpdateDt(Instant.now());

        bankAccountRepository.save(bankAccount);
    }
}
