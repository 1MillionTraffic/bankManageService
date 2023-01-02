package com.onemillion.bankmanager.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UserResponseDto {
    @JsonProperty("api_tran_id")
    private String apiTranId;
    @JsonProperty("api_tran_dtm")
    private String apiTranDtm;
    @JsonProperty("rsp_code")
    private String rspCode;
    @JsonProperty("rsp_message")
    private String rspMessage;
    @JsonProperty("user_seq_no")
    private String userSeqNo;
    @JsonProperty("user_ci")
    private String userCi;
    @JsonProperty("res_cnt")
    private String resCnt;
    @JsonProperty("res_list")
//    @JsonDeserialize(using = ResListDeserializer.class)
    private Object resList;
    @JsonProperty("--fintech_user_num")
    private String fintechUserNum;
    @JsonProperty("--account_alias")
    private String accountAlias;
    @JsonProperty("--bank_code_std")
    private String bankCodeStd;
    @JsonProperty("--bank_code_sub")
    private String bankCodeSub;
    @JsonProperty("--bank_name")
    private String bankName;
    @JsonProperty("--savings_bank_name")
    private String savingsBankName;
    @JsonProperty("account_num_masked")
    private String accountNumMasked;
    @JsonProperty("--account_seq")
    private String accountSeq;
    @JsonProperty("--account_holder_name")
    private String accountHolderName;
    @JsonProperty("--account_holder_type")
    private String accountHolderType;
    @JsonProperty("--account_type")
    private String accountType;
    @JsonProperty("--inquiry_agree_yn")
    private String inquireAgreeYn;
    @JsonProperty("--inquiry_agree_dtime")
    private String inquireAgreeDtime;
    @JsonProperty("--transfer_agree_yn")
    private String transferAgreeYn;
    @JsonProperty("--transfer_agree_dtime")
    private String transferAgreeDtime;
    @JsonProperty("--payer_num")
    private String payerNum;
}
