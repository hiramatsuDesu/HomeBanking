package com.hexagonalExample.hexagonalExample.port.in.web;

import com.hexagonalExample.hexagonalExample.application.dto.HomeBankingDTO;
import com.hexagonalExample.hexagonalExample.application.dto.ZeisureDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface WebPort {
    @PostMapping("/homeBanking")
    HomeBankingDTO open(@RequestBody String name);

    @PostMapping("/homeBanking/{customerId}/{accountId}/take/{balance}")
    HomeBankingDTO takeBalance(@PathVariable String customerId, @PathVariable String accountId, @PathVariable double balance);

    @PostMapping("/homeBanking/{customerId}/{accountId}/add/{balance}")
    HomeBankingDTO addBalance(@PathVariable String customerId, @PathVariable String accountId, @PathVariable double balance);

    @PostMapping("/homeBanking/{customerId}/{accountId}/warn/{orderId}")
    void zeisure(@PathVariable String customerId, @PathVariable String accountId, @PathVariable String orderId);

}
