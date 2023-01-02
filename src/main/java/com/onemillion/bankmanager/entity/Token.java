package com.onemillion.bankmanager.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String accessToken;
    @Column(length = 1000)
    private String refreshToken;

    private String tokenType;
    private int expiresIn;
    private String scope;
    private String userSeqNo;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public Token() {
    }

    @Builder
    public Token(Long id, String accessToken, String refreshToken, String tokenType, int expiresIn, String scope, String userSeqNo, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.userSeqNo = userSeqNo;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }



    @PrePersist
    public void prePersist() {
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedAt = LocalDateTime.now();
    }
}
