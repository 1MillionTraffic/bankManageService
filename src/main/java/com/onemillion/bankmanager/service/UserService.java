package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.model.dto.UserDTO;
import com.onemillion.bankmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void syncUser(UserDTO userDTO) {

    }

    public UserDTO getUser(String userSeqNo) {
        return UserDTO.parse(userRepository.findByUserSeqNo(userSeqNo));
    }
}
