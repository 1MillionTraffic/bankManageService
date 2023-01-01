package com.onemillion.bankmanager.model.dto.openapi;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {

    private String userSeqNo;
    private String userCi;
    private String userName;

    @JsonAlias("res_list")
    private List<BankAccountDTO> bankAccountList;
}
