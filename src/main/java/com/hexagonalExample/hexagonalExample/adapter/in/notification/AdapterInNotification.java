package com.hexagonalExample.hexagonalExample.adapter.in.notification;

import com.hexagonalExample.hexagonalExample.application.HomeBankingService;
import com.hexagonalExample.hexagonalExample.application.dto.ZeisureDTO;
import com.hexagonalExample.hexagonalExample.port.in.notification.PortInNotification;
import org.springframework.beans.factory.annotation.Autowired;

public class AdapterInNotification implements PortInNotification {

    @Autowired
    private HomeBankingService homeBankingService;

    @Override
    public void handleNotificationZeisure(ZeisureDTO zeisureDTO, String accountId, String customerId){
        homeBankingService.ZeisureApplied(zeisureDTO, accountId, customerId);
    }
}
