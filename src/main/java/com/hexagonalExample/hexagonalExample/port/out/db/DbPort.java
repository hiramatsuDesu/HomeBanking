package com.hexagonalExample.hexagonalExample.port.out.db;

import com.hexagonalExample.hexagonalExample.application.dto.HomeBankingDTO;

public interface DbPort {
    void accountOpening(HomeBankingDTO homeBanking);
    void updateStatus(String accountId, String customerId, String status);
}
