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
@Table(name="TB_SUBDIVISION")
public class ProductSubDivision {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUBDIVISION_ID")
	private Long id;
	
	@Column(name="SUBDIVISION_NAME")
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(
			name="SUBDIVISION_REFER_ID", referencedColumnName="MIDDLE_CATEGORY_ID"
			)
	private ProductMiddleCategory productMiddleCategory;
}
