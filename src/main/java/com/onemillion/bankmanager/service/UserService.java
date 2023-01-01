package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.model.dto.openapi.UserResponse;
import com.onemillion.bankmanager.model.entity.User;
import com.onemillion.bankmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void syncUser(UserResponse userResponse) {

    }

    public User getUser(String userSeqNo) {
        return new User();
    }
}
