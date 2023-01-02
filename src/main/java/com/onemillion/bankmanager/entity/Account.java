package com.onemillion.bankmanager.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Account() {
    }
    private LocalDateTime createAt;

    private LocalDateTime modifiedAt;

    @PrePersist
    public void prePersist(){
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.modifiedAt = LocalDateTime.now();
    }
}
