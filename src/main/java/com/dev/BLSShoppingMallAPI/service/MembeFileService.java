package com.dev.BLSShoppingMallAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.BLSShoppingMallAPI.repository.MemberFileRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MembeFileService{

	@Autowired
	MemberFileRepository memberFileRepository;

}
