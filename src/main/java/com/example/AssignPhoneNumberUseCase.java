package com.example;

import com.example.domain.Account;
import com.example.domain.AccountRepository;
import com.example.domain.PhoneNumber;

import com.example.domain.PhoneNumberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssignPhoneNumberUseCase {
    private final PhoneNumberRepository phoneNumberRepository;
    private final AccountRepository accountRepository;

    public AssignPhoneNumberUseCase(
            PhoneNumberRepository phoneNumberRepository,
            AccountRepository accountRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void execute(String accountId, PhoneNumber phoneNumber) {
        Account account = accountRepository.findByIdOrThrow(accountId);
        phoneNumberRepository.savePhoneNumberToAccount(account, phoneNumber);
    }
}
