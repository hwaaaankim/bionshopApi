package com.dev.BLSShoppingMallAPI.model.member;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dev.BLSShoppingMallAPI.model.product.Product;

import lombok.Data;

@Data
@Entity
@Table(name="TB_MEMBER_CART")
public class MemberCart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MEMBER_CART_ID")
	private Long id;
	
	@Column(name="MEMBER_CART_DATE")
	private Date date;
	
	@Column(name="MEMBER_CART_QUANTITY")
	private int quantity;
	
	@Column(name="MEMBER_CART_REFER_ID")
	private Long memberId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name="MEMBER_CART_PRODUCT_ID", referencedColumnName="PRODUCT_ID"
			)
	private Product product;
}
