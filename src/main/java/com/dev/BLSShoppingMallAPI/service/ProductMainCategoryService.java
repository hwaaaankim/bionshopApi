package com.dev.BLSShoppingMallAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.BLSShoppingMallAPI.model.product.ProductMainCategory;
import com.dev.BLSShoppingMallAPI.repository.ProductMainCategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductMainCategoryService{


	@Autowired
	ProductMainCategoryRepository productMainCategoryRepository;
	
	public void insertCategory(String name) {
		ProductMainCategory category = new ProductMainCategory();
		category.setName(name);
		productMainCategoryRepository.save(category);
	}
}
