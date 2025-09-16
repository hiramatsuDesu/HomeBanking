package com.hexagonalExample.hexagonalExample.domain;

import java.rmi.server.UID;
import java.util.UUID;

public class Customer {
    private String name;
    private String id;

    public Customer(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
