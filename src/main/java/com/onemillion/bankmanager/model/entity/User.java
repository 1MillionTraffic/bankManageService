package com.onemillion.bankmanager.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    private long uid;
    private String userSeqNo;
    private String userCi;
    private String userName;
}
