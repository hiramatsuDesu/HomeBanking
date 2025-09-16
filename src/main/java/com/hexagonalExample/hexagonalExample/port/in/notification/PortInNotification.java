package com.hexagonalExample.hexagonalExample.port.in.notification;

import com.hexagonalExample.hexagonalExample.application.dto.ZeisureDTO;

public interface PortInNotification {
    void handleNotificationZeisure(ZeisureDTO zeisure, String accountId, String customerId);
}
