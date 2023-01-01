package com.onemillion.bankmanager.user;


public class User {
    private Long id;
    private String accessToken;
    private String refreshToken;

    public User() {
    }

    public User(Long id, String accessToken, String refreshToken) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public Long getId() {
        return id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
