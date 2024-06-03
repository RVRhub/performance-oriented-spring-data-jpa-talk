package com.example.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
public class Account {
    @Id
    private String id;

    private String iban;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {PERSIST, MERGE})
    private Set<PhoneNumber> phoneNumbers;

    public Account() {
    }

    public Account(String id, String iban, String firstName, String lastName) {
        this.id = id;
        this.iban = iban;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = new HashSet<>();
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
        phoneNumber.setAccount(this);
    }


    public String getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers.stream().toList();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
