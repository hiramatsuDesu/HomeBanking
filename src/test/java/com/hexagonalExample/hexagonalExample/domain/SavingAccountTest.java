package com.hexagonalExample.hexagonalExample.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingAccountTest {
    private SavingAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingAccount("account-123");
    }

    @Test
    void initialBalanceShouldBeZero() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void addBalanceShouldIncreaseBalance() {
        account.addBalance(500.0);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void takeBalanceShouldDecreaseBalance() {
        account.addBalance(1000.0);
        account.takeBalance(300.0);
        assertEquals(700.0, account.getBalance());
    }

    @Test
    void addBalanceZeroShouldThrowException() {
        assertThrows(ceroAmount.class, () -> account.addBalance(0.0));
    }

    @Test
    void takeBalanceZeroShouldThrowException() {
        assertThrows(ceroAmount.class, () -> account.takeBalance(0.0));
    }

    @Test
    void getAccountNumberShouldReturnCorrectValue() {
        assertEquals("account-123", account.getAccountNumber());
    }

    @Test
    void statusShouldBeCreatedInitially() {
        assertEquals(Status.CREATED, account.getStatus());
    }

    @Test
    void setStatusShouldUpdateStatus() {
        account.setStatus(Status.OPEN);
        assertEquals(Status.OPEN, account.getStatus());
    }
}
