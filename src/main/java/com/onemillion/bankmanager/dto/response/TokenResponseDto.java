package com.onemillion.bankmanager.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponseDto {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private int expiresIn;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("user_seq_no")
    private String userSeqNo;

    @JsonProperty("rsp_code")
    private String rspCode;

    @JsonProperty("rsp_message")
    private String rspMessage;


    public TokenResponseDto() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public String getUserSeqNo() {
        return userSeqNo;
    }

    public String getRspCode() {
        return rspCode;
    }

    public String getRspMessage() {
        return rspMessage;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setUserSeqNo(String userSeqNo) {
        this.userSeqNo = userSeqNo;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public void setRspMessage(String rspMessage) {
        this.rspMessage = rspMessage;
    }

    @Override
    public String toString() {
        return "TokenResponseDto{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                ", scope='" + scope + '\'' +
                ", userSeqNo='" + userSeqNo + '\'' +
                ", rspCode='" + rspCode + '\'' +
                ", rspMessage='" + rspMessage + '\'' +
                '}';
    }
}
