package com.hexagonalExample.hexagonalExample.adapter.out.db.repository;

import com.hexagonalExample.hexagonalExample.adapter.out.db.model.HomeBankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepository extends JpaRepository<HomeBankingEntity, String> {


}
