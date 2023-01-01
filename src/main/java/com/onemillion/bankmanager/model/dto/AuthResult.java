package com.onemillion.bankmanager.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResult {
    private final boolean isLogin;
    private final String accessToken;
    private final String refreshToken;
}
