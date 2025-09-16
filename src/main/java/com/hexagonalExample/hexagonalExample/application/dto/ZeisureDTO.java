package com.hexagonalExample.hexagonalExample.application.dto;

public class ZeisureDTO {
    private String orderId;

    public ZeisureDTO(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId(){
        return orderId;
    }
}
