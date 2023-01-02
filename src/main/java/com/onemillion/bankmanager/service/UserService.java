package com.onemillion.bankmanager.service;


import com.onemillion.bankmanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Transactional
//    public void save(UserSaveResponseDto requestDto){
//
//    }


}
