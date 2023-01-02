package com.onemillion.bankmanager.repository;

import com.onemillion.bankmanager.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
