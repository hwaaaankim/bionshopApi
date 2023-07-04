package com.dev.BLSShoppingMallAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.BLSShoppingMallAPI.repository.ProductSubDivisionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductSubDivisionService{


	@Autowired
	ProductSubDivisionRepository productSubDivisionRepository;
}
