package com.onemillion.bankmanager.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class User {
    @Id
    private long id;
    private String userSeqNo;
    private String userCi;
    private String userName;

    private Instant createDt;
    private Instant updateDt;
}
