package com.onemillion.bankmanager.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private final String userSeqNo;
    private final String userCi;
    private final String userName;
}
