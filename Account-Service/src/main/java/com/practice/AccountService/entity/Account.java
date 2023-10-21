package com.practice.AccountService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Account {

    @Id
    private String id;

    private String emailAddress;

    private long accountNumber;

    private String name;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isMessageSent;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Account(){
        this.id= UUID.randomUUID().toString();
    }
}
