package com.onemillion.bankmanager.dto;


public class AuthUser {
    private final boolean isLogin;
    private final String accessToken;
    private final String refreshToken;

    public AuthUser(boolean isLogin, String accessToken, String refreshToken) {
        this.isLogin = isLogin;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
