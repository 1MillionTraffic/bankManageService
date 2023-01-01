package com.onemillion.bankmanager.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userSeqNo;
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

    private Instant createDt = Instant.now();
    private Instant updateDt = Instant.now();
}
