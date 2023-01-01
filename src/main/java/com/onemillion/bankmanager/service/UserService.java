package com.onemillion.bankmanager.service;

import com.onemillion.bankmanager.model.dto.UserDTO;
import com.onemillion.bankmanager.model.entity.User;
import com.onemillion.bankmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void syncUser(UserDTO userDTO) {
        User user = userRepository.findByUserSeqNo(userDTO.getUserSeqNo());

        if(Objects.isNull(user)) {
            user = new User();
            user.setUserCi(userDTO.getUserCi());
            user.setUserSeqNo(userDTO.getUserSeqNo());
            user.setUserName(userDTO.getUserName());
        }

        user.setUpdateDt(Instant.now());

        userRepository.save(user);
    }

    public UserDTO getUser(String userSeqNo) {
        return UserDTO.parse(userRepository.findByUserSeqNo(userSeqNo));
    }
}
