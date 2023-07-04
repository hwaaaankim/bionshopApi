package com.dev.BLSShoppingMallAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BLSShoppingMallAPI.model.member.MemberFile;

@Repository
public interface MemberFileRepository extends JpaRepository<MemberFile, Long>{

}
