package com.onemillion.bankmanager.config;

public enum URL {
    AUTHORIZE_CALLBACK_URL("http://localhost:8080/api/oauth/callback");

    private final String value;

    URL(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
