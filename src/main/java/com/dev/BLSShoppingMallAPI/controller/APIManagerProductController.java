package com.dev.BLSShoppingMallAPI.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.BLSShoppingMallAPI.constant.JwtTokenProvider;
import com.dev.BLSShoppingMallAPI.repository.ProductMainCategoryRepository;
import com.dev.BLSShoppingMallAPI.repository.ProductMiddleCategoryRepository;
import com.dev.BLSShoppingMallAPI.repository.ProductRepository;
import com.dev.BLSShoppingMallAPI.repository.ProductSubDivisionRepository;
import com.dev.BLSShoppingMallAPI.service.ProductMainCategoryService;
import com.dev.BLSShoppingMallAPI.service.ProductMiddleCategoryService;
import com.dev.BLSShoppingMallAPI.service.ProductService;
import com.dev.BLSShoppingMallAPI.service.ProductSubDivisionService;
import com.dev.BLSShoppingMallAPI.utils.ConvertUtils;

@RestController
@RequestMapping("/api/v1/administration")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class APIManagerProductController {

	@Autowired
	ProductMainCategoryRepository productMainCategoryRepository;
	
	@Autowired
	ProductMiddleCategoryRepository productMiddleCategoryRepository;
	
	@Autowired
	ProductSubDivisionRepository productSubDivisionRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMainCategoryService productMainCategoryService;
	
	@Autowired
	ProductMiddleCategoryService productMiddleCategoryService;
	
	@Autowired
	ProductSubDivisionService productSubDivisionService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	ConvertUtils convertUtils;
	
	@PostMapping(value = "/insertCategory/{code}", produces = "application/json; charset=utf8")
	public String insertCategory(
			@PathVariable int code,
			@RequestBody Map<String, Object> data
			
			) {
		try {
			if(code == 1) {
				productMainCategoryService.insertCategory((String)data.get("name"));
			}else if(code == 2) {
				productMiddleCategoryService.insertCategory((String)data.get("name"), productMainCategoryRepository.findById(convertUtils.objectToLong(data.get("referId"))).get());
			}else if(code == 3) {
				productSubDivisionService.insertCategory((String)data.get("name"), productMiddleCategoryRepository.findById(convertUtils.objectToLong(data.get("referId"))).get());
			}
			StringBuffer sb = new StringBuffer();
			String msg = "제품 카테고리가 등록 되었습니다.";

			sb.append("alert('" + msg + "');");
			sb.append("</script>");
			sb.insert(0, "<script>");

			return sb.toString();
		}catch(InvalidDataAccessApiUsageException e) {
			StringBuffer sb = new StringBuffer();
			String msg = "해당 카테고리가 포함될 상위 카테고리의 ID를 입력 해 주세요.";

			sb.append("alert('" + msg + "');");
			sb.append("</script>");
			sb.insert(0, "<script>");

			return sb.toString();
		}
		
		
	}
}



















