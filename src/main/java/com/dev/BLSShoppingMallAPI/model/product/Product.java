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
@Table(name="TB_PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private Long id;
	
	@Column(name="PRODUCT_NAME")
	private String name;
	
	@Column(name="PRODUCT_REFERED_ID")
	private Long productSubDivisionId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(
			name="PRODUCT_REFER_ID", referencedColumnName="SUBDIVISION_ID"
			)
	private ProductSubDivision productSubDivision;
	
	@OneToMany(
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL,
			orphanRemoval=true,
			mappedBy = "productId"
			)
	private List<ProductImage> images;
}
