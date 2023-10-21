package com.practice.AccountService.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {
    private String emailAddress;

    private long accountNumber;

    private String name;
}
