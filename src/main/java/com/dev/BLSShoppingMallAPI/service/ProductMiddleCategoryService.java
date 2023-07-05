package com.dev.BLSShoppingMallAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.BLSShoppingMallAPI.model.product.ProductMainCategory;
import com.dev.BLSShoppingMallAPI.model.product.ProductMiddleCategory;
import com.dev.BLSShoppingMallAPI.repository.ProductMiddleCategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductMiddleCategoryService{

	@Autowired
	ProductMiddleCategoryRepository productMiddleCategoryRepository;
	
	public void insertCategory(String name, ProductMainCategory category) {
		
		ProductMiddleCategory middleCategory = new ProductMiddleCategory();
		middleCategory.setProductMainCategory(category);
		middleCategory.setName(name);
		middleCategory.setProductMainCategoryId(category.getId());
		
		productMiddleCategoryRepository.save(middleCategory);
	}

}
