package com.dev.BLSShoppingMallAPI.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="TB_MIDDLE_CATEGORY")
public class ProductMiddleCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MIDDLE_CATEGORY_ID")
	private Long id;
	
	@Column(name="MIDDLE_CATEGORY_NAME")
	private String name;
	
	@Column(name="MIDDLE_CATEGORY_REFERED_ID")
	private Long productMainCategoryId;
	
	@OneToMany(
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL,
			orphanRemoval=true,
			mappedBy = "productMiddleCategoryId"
			)
	private List<ProductSubDivision> categories;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(
			name="MIDDLE_CATEGORY_REFER_ID", referencedColumnName="MAIN_CATEGORY_ID"
			)
	private ProductMainCategory productMainCategory;
}
