package com.example.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID phoneNumberId;

    @Column
    private String number;

    @Column
    @Enumerated(EnumType.STRING)
    Type type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public PhoneNumber() {

    }

    public PhoneNumber(String number, Type type) {
        this.number = number;
        this.type = type;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public enum Type {
        HOME,
        WORK
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhoneNumber that = (PhoneNumber) o;
        return (this.phoneNumberId != null &&
                Objects.equals(phoneNumberId, that.phoneNumberId));
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumberId);
    }
}
