package com.practice.AccountService.repository;

import com.practice.AccountService.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Account,String> {
    Account findByAccountNumber(long accountNumber);
}
