package com.dev.BLSShoppingMallAPI.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TB_PRODUCT_IMAGE")
public class ProductImage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_IMAGE_ID")
	private Long id;
	
	@Column(name="PRODUCT_IMAGE_PATH")
	private String path;
	
	@Column(name="PRODUCT_IMAGE_REFER_ID")
	private Long productId;
	
}
