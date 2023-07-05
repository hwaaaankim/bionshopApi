package com.dev.BLSShoppingMallAPI.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL,
			orphanRemoval=true,
			mappedBy = "productMainCategoryId"
			)
	private List<ProductMiddleCategory> categories;
}
