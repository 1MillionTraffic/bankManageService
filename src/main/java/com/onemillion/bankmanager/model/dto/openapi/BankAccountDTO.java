package com.onemillion.bankmanager.model.dto.openapi;

import com.onemillion.bankmanager.model.entity.BankAccount;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {
    private String fintechUseNum;
    private String accountAlias;
    private String bankCodeStd;
    private String bankCodeSub;
    private String bankName;
    private String savingsBankName;
    private String accountNumMasked;
    private String accountSeq;
    private String accountHolderName;
    private String accountHolderType;
    private String accountType;
    private String inquiryAgreeYn;
    private String inquiryAgreeDtime;
    private String transferAgreeYn;
    private String transferAgreeDtime;
    private String payerNum;

    public static BankAccountDTO parse(BankAccount bankAccount) {
        return BankAccountDTO.builder()
                .fintechUseNum(bankAccount.getFintechUseNum())
                .accountAlias(bankAccount.getAccountAlias())
                .bankCodeStd(bankAccount.getBankCodeStd())
                .bankCodeSub(bankAccount.getBankCodeSub())
                .bankName(bankAccount.getBankName())
                .savingsBankName(bankAccount.getSavingsBankName())
                .accountNumMasked(bankAccount.getAccountNumMasked())
                .accountSeq(bankAccount.getAccountSeq())
                .accountHolderName(bankAccount.getAccountHolderName())
                .accountHolderType(bankAccount.getAccountHolderType())
                .accountType(bankAccount.getAccountType())
                .inquiryAgreeYn(bankAccount.getInquiryAgreeYn())
                .inquiryAgreeDtime(bankAccount.getInquiryAgreeDtime())
                .transferAgreeYn(bankAccount.getTransferAgreeYn())
                .transferAgreeDtime(bankAccount.getTransferAgreeDtime())
                .payerNum(bankAccount.getPayerNum())
                .build();
    }
}
