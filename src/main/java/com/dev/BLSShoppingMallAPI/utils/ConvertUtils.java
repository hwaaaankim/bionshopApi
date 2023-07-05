package com.dev.BLSShoppingMallAPI.utils;

import org.springframework.stereotype.Component;

@Component
public class ConvertUtils {

	public Long objectToLong(Object object) {
		
		return Long.valueOf(String.valueOf(object));
	}
}
