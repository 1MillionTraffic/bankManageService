package com.onemillion.bankmanager.model.dto;

import com.onemillion.bankmanager.model.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    private final String userSeqNo;
    private final String userCi;
    private final String userName;

    public static UserDTO parse(User user) {
        return UserDTO.builder()
                .userCi(user.getUserCi())
                .userName(user.getUserName())
                .userSeqNo(user.getUserSeqNo())
                .build();
    }
}
