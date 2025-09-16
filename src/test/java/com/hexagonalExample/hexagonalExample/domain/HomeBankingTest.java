package com.hexagonalExample.hexagonalExample.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HomeBankingTest {
    private HomeBanking homeBanking;
    private String customerId;
    private String productId;

    @BeforeEach
    void setUp() {
        homeBanking = new HomeBanking("Juan Perez");
        customerId = homeBanking.getProduct().getAccountNumber();
        productId = homeBanking.getProduct().getId();
    }

    @Test
    void depositWithinLimitShouldIncreaseBalance() {
        double balance = homeBanking.deposit(customerId, productId, 5000.0);
        assertEquals(5000.0, balance);
    }

    @Test
    void depositExceedingLimitShouldThrowException() {
        assertThrows(TopExceeded.class, () -> {
            homeBanking.deposit(customerId, productId, 20000000.0);
        });
    }

    @Test
    void depositWithWrongIdsShouldNotChangeBalance() {
        double balance = homeBanking.deposit("wrongCustomerId", "wrongProductId", 5000.0);
        assertEquals(0.0, balance); // balance inicial es 0
    }

    @Test
    void takeWithinLimitShouldDecreaseBalance() {
        // Primero depositamos para poder retirar
        homeBanking.deposit(customerId, productId, 10000.0);
        double balance = homeBanking.take(customerId, productId, 5000.0);
        assertEquals(5000.0, balance);
    }

    @Test
    void takeExceedingLimitShouldThrowException() {
        assertThrows(TopExceeded.class, () -> {
            homeBanking.take(customerId, productId, 20000000.0);
        });
    }

    @Test
    void takeWithWrongIdsShouldNotChangeBalance() {
        homeBanking.deposit(customerId, productId, 5000.0);
        double balance = homeBanking.take("wrongCustomerId", "wrongProductId", 1000.0);
        assertEquals(5000.0, balance);
    }

}
