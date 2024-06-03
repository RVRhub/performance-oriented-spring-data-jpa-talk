package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, UUID> {

    default void savePhoneNumberToAccount(Account account, PhoneNumber phoneNumber) {
        phoneNumber.setAccount(account);
        save(phoneNumber);
    }
}