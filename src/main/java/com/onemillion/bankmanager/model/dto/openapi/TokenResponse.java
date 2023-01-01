package com.onemillion.bankmanager.model.dto.openapi;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.onemillion.bankmanager.model.dto.openapi.deserializer.ScopeDeserializer;
import com.onemillion.bankmanager.model.enums.TokenScope;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private int expiresIn;
    private String userSeqNo;
    @JsonDeserialize(using = ScopeDeserializer.class)
    private List<TokenScope> scope;
}
