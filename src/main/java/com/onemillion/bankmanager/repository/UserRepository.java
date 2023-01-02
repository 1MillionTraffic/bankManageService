package com.onemillion.bankmanager.repository;

import com.onemillion.bankmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
