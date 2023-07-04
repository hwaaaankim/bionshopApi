package com.dev.BLSShoppingMallAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BLSShoppingMallAPI.model.member.MemberLog;

@Repository
public interface MemberLogRepository extends JpaRepository<MemberLog, Long>{

}
