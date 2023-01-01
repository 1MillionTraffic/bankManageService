package com.onemillion.bankmanager.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
@Builder
public class AuthCookie {
    private static final String DELIMITER="/";

    private final String userSeqNo;
    private final String token;

    @Override
    public String toString() {
        return String.join(DELIMITER, userSeqNo, token);
    }

    public static AuthCookie parse(String rawCookie) {
        if(Objects.isNull(rawCookie)) {
            return null;
        }

        String[] result = rawCookie.split(DELIMITER);
        if(result.length != 2) {
            return null;
        }

        return AuthCookie.builder()
                .userSeqNo(result[0])
                .token(result[1])
                .build();
    }
}
