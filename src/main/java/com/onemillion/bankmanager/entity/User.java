package com.onemillion.bankmanager.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Token token;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public User() {
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @PrePersist
    public void prePersist(){
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.modifiedAt = LocalDateTime.now();
    }


}
