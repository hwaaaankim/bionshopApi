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
@Table(name="TB_MAIN_CATEGORY")
public class ProductMainCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MAIN_CATEGORY_ID")
	private Long id;
	
	@Column(name="MAIN_CATEGORY_NAME")
	private String name;
}
