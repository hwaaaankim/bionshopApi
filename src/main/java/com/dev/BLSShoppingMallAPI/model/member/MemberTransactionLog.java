package com.dev.BLSShoppingMallAPI.model.member;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TB_MEMBER_TRANSACTION_LOG")
public class MemberTransactionLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MEMBER_TRANSACTION_LOG_ID")
	private Long id;
	
	@Column(name="MEMBER_TRANSACTION_LOG_SUBJECT")
	private String subject;
	
	@Column(name="MEMBER_TRANSACTION_LOG_DATE")
	private Date date;
	
	@Column(name="MEMBER_TRANSACTION_LOG_REFER_ID")
	private Long memberId;
}
