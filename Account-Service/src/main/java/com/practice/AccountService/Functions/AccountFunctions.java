package com.practice.AccountService.Functions;

import com.practice.AccountService.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Log4j2
@RequiredArgsConstructor
public class AccountFunctions {

    private final AccountService accountService;

    @Bean
    public Consumer<Long> updateNotification(){
        return accountNum->{
            log.info("started updating notification for account number {}",accountNum);
            accountService.updateNotification(accountNum);
            log.info("completed updating notification for account number {}",accountNum);
        };
    }
}
