package com.hexagonalExample.hexagonalExample.domain;

import java.util.Objects;

public class HomeBanking {
    private double TOP_DEPOSIT = 10000000.00;
    private double TOP_TAKE = 10000000.00;

    private SavingAccount product;
    private Customer customer;
    private Status status;
    private String accountId;

    public HomeBanking(String name){
        this.customer = new Customer(name);
        this.status = Status.OPEN;
        this.product = new SavingAccount(customer.getId());
        this.accountId = product.getId();
    }

    public double deposit(String customerId, String productId, double amount){
        String idCustomer = customer.getId();
        String idProduct = product.getId();

        if (TOP_DEPOSIT < amount){
            throw new TopExceeded();
        }

        if (Objects.equals(idCustomer, customerId) && Objects.equals(idProduct,productId)){
            product.addBalance(amount);
        }
        return product.getBalance();
    }

    public double take(String customerId, String productId, double amount) {
        String idCustomer = customer.getId();
        String idProduct = product.getId();

        if (TOP_TAKE < amount){
            throw new TopExceeded();
        }

        if (Objects.equals(idCustomer,customerId) && Objects.equals(idProduct,productId)){
            product.takeBalance(amount);
        }
        return product.getBalance();
    }

    public SavingAccount getProduct() {
        return product;
    }
}
