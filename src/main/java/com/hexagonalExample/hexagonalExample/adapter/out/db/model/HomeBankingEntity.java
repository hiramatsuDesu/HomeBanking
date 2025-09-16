package com.hexagonalExample.hexagonalExample.adapter.out.db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HomeBankingEntity {

    private String customerId;
    @Id
    private String productId;
    private double balance;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
