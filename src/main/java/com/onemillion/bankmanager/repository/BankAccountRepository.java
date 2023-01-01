package com.onemillion.bankmanager.repository;

import com.onemillion.bankmanager.model.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findAllByUserSeqNo(String userSeqNo);
    BankAccount findByFintechUseNum(String fintechUseNum);
}
