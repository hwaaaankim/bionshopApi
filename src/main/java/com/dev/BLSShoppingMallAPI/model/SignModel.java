package com.dev.BLSShoppingMallAPI.model;

import com.dev.BLSShoppingMallAPI.model.member.Member;

import lombok.Data;

@Data
public class SignModel {

	private Member member;
	private String message;
	private String token;
}
