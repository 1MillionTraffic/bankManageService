package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public User findUserBySeqNo(String userSeqNo) {
        return new User();
    }
}
