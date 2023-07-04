package com.dev.BLSShoppingMallAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BLSShoppingMallAPI.model.member.MemberCart;

@Repository
public interface MemberCartRepository extends JpaRepository<MemberCart, Long>{

}
