package com.dev.BLSShoppingMallAPI.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(
			name="MIDDLE_CATEGORY_REFER_ID", referencedColumnName="MAIN_CATEGORY_ID"
			)
	private ProductMainCategory productMainCategory;
}
