package com.dev.BLSShoppingMallAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.BLSShoppingMallAPI.model.product.ProductSubDivision;

@Repository
public interface ProductSubDivisionRepository extends JpaRepository<ProductSubDivision, Long>{

}
