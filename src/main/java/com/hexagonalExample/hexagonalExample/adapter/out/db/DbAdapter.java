package com.hexagonalExample.hexagonalExample.adapter.out.db;

import com.hexagonalExample.hexagonalExample.adapter.out.db.model.HomeBankingEntity;
import com.hexagonalExample.hexagonalExample.adapter.out.db.repository.DbRepository;
import com.hexagonalExample.hexagonalExample.application.dto.HomeBankingDTO;
import com.hexagonalExample.hexagonalExample.port.out.db.DbPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbAdapter implements DbPort {

    @Autowired
    private DbRepository dbRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void accountOpening(HomeBankingDTO homeBankingDTO){
        HomeBankingEntity homeBankingEntity = modelMapper.map(homeBankingDTO, HomeBankingEntity.class);
    }

    @Override
    public void updateStatus(String accountId, String customerId, String status){

    }

}
