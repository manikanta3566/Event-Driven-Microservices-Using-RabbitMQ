package com.practice.MessagingService.Functions;

import com.practice.MessagingService.DTO.AccountMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    public static final Logger log= LoggerFactory.getLogger(MessageFunctions.class);


    @Bean
    public Function<AccountMessageDto,Long> email(){
        return accountMessageDto -> {
          log.info("started sending email for {} ",accountMessageDto.toString());
          log.info("completed sending email for {} ", accountMessageDto.toString());
          return accountMessageDto.accountNumber();
        };
    }

    @Bean
    public Function<AccountMessageDto,AccountMessageDto> sms(){
        return accountMessageDto -> {
            log.info("started sending sms for {} ",accountMessageDto.toString());
            log.info("completed sending sms for {} ", accountMessageDto.toString());
            return accountMessageDto;
        };
    }

}
