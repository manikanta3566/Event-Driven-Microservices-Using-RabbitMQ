package com.practice.AccountService.service;

import com.practice.AccountService.DTO.AccountMessageDto;
import com.practice.AccountService.DTO.AccountRequestDto;
import com.practice.AccountService.entity.Account;
import com.practice.AccountService.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountService {

    private final StreamBridge streamBridge;

    private final AccountsRepository accountsRepository;
    public String createAccount(AccountRequestDto accountRequestDto){
        Account account=new Account();
        account.setName(accountRequestDto.getName());
        account.setEmailAddress(accountRequestDto.getEmailAddress());
        account.setAccountNumber(accountRequestDto.getAccountNumber());
        accountsRepository.save(account);
        sendMessageToQueue(accountRequestDto,account);
        return "account created successfully";
    }

    private void sendMessageToQueue(AccountRequestDto accountRequestDto, Account account) {
        AccountMessageDto accountMessageDto=new AccountMessageDto(accountRequestDto.getName(),accountRequestDto.getAccountNumber(),accountRequestDto.getEmailAddress());
        log.info("sending message to the queue for account id {} ::::: request {} ",account.getId(),accountMessageDto);
        boolean isSent = streamBridge.send("messageExchange-out-0", accountMessageDto);
        log.info("completed sending message to the queue for account id {}::: isSent {} ",account.getId(),isSent);
    }

    public void updateNotification(Long accountNum) {
        if (Objects.nonNull(accountNum)){
            Account acc = accountsRepository.findByAccountNumber(accountNum);
            acc.setMessageSent(true);
            accountsRepository.save(acc);
        }
    }
}
