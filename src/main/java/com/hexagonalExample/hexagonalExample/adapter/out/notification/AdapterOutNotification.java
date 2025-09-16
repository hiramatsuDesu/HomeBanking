package com.hexagonalExample.hexagonalExample.adapter.out.notification;

import com.hexagonalExample.hexagonalExample.application.dto.HomeBankingDTO;
import com.hexagonalExample.hexagonalExample.port.out.notification.PortOutNotification;
import org.springframework.stereotype.Service;

@Service
public class AdapterOutNotification implements PortOutNotification {

    @Override
    public void notifyHomeBankingBalance(HomeBankingDTO homeBankingDTO){

    }
}
