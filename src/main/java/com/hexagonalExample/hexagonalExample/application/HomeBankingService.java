package com.hexagonalExample.hexagonalExample.application;

import com.hexagonalExample.hexagonalExample.application.dto.HomeBankingDTO;
import com.hexagonalExample.hexagonalExample.application.dto.ZeisureDTO;
import com.hexagonalExample.hexagonalExample.domain.HomeBanking;
import com.hexagonalExample.hexagonalExample.domain.SavingAccount;
import com.hexagonalExample.hexagonalExample.domain.Status;
import com.hexagonalExample.hexagonalExample.port.out.db.DbPort;
import com.hexagonalExample.hexagonalExample.port.out.notification.PortOutNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HomeBankingService {
    private HomeBanking homeBanking;

    @Autowired
    private DbPort dbPort;

    @Autowired
    private PortOutNotification portOutNotification;

    public HomeBankingDTO openAccount(String name) {
        this.homeBanking = new HomeBanking(name);
        HomeBankingDTO homeBankingDTO = new HomeBankingDTO();
        String accountId = homeBanking.getProduct().getId();
        String customerId = homeBanking.getProduct().getAccountNumber();
        homeBankingDTO.setCustomerId(customerId);
        homeBankingDTO.setProductId(accountId);
        homeBankingDTO.setBalance(0.0);

        dbPort.accountOpening(homeBankingDTO);

        return homeBankingDTO;
    }

    public HomeBankingDTO getHomeBanking(String customerId, String accountId, HomeBanking balance){
        HomeBankingDTO homeBankingDTO = new HomeBankingDTO();
        homeBankingDTO.setProductId(accountId);
        homeBankingDTO.setCustomerId(customerId);
        homeBankingDTO.setBalance(homeBanking.getProduct().getBalance());

        return homeBankingDTO;
    }

    public HomeBankingDTO addAmount(String customerId, String accountId, double amount){
        SavingAccount savingAccount = homeBanking.getProduct();
        savingAccount.addBalance(amount);

        return getHomeBanking(customerId, accountId, homeBanking);
    }

    public HomeBankingDTO takeAmount(String customerId, String accountId, double amount){
        SavingAccount savingAccount = homeBanking.getProduct();
        savingAccount.takeBalance(amount);

        return getHomeBanking(customerId, accountId, homeBanking);
    }

    public void ZeisureApplied(ZeisureDTO zeisureDTO, String accountId, String customerId) {
        if(zeisureDTO.getOrderId() != null) {
            dbPort.updateStatus(accountId, customerId, Status.SUSPENDED.toString());
        }
        this.homeBanking.getProduct().setStatus(Status.SUSPENDED);
    }
}
