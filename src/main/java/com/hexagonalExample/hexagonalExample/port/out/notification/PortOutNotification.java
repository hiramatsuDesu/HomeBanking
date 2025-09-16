package com.hexagonalExample.hexagonalExample.port.out.notification;

import com.hexagonalExample.hexagonalExample.application.dto.HomeBankingDTO;

public interface PortOutNotification {
    void notifyHomeBankingBalance(HomeBankingDTO homeBanking);
}
