package com.hexagonalExample.hexagonalExample.domain;

import java.util.UUID;

public class SavingAccount {
    private String id;
    private double balance;
    private String accountNumber;
    private Status status;

    public SavingAccount(String accountNumber) {
        this.id = UUID.randomUUID().toString();
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.status = Status.CREATED;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void addBalance(double amount){
        if (amount == 0.0) {
            throw new ceroAmount();
        }
        balance += amount;
    }

    public void takeBalance(double amount){
        if (amount == 0.0) {
            throw new ceroAmount();
        }
        balance -= amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
