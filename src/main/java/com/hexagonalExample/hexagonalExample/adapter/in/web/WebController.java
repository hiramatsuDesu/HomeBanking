package com.hexagonalExample.hexagonalExample.adapter.in.web;

import com.hexagonalExample.hexagonalExample.application.HomeBankingService;
import com.hexagonalExample.hexagonalExample.application.dto.HomeBankingDTO;
import com.hexagonalExample.hexagonalExample.domain.HomeBanking;
import com.hexagonalExample.hexagonalExample.port.in.web.WebPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WebController implements WebPort {

    @Autowired
    private HomeBankingService homeBankingService;

    @Override
    public HomeBankingDTO open(String name) {
        return homeBankingService.openAccount(name);
    }

    @Override
    public HomeBankingDTO takeBalance (String customerId, String accountId, double balance) {
        return homeBankingService.takeAmount(customerId, accountId, balance);
    }
    @Override
    public HomeBankingDTO addBalance (String customerId,String accountId, double balance) {
        return homeBankingService.addAmount(customerId, accountId, balance);
    }

    @Override
    public void zeisure(String customerId, String accountId, String orderId){
        //zeisure the account
    }
}
