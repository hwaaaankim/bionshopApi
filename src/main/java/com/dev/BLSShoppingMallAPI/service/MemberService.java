package com.dev.BLSShoppingMallAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.BLSShoppingMallAPI.model.member.Member;
import com.dev.BLSShoppingMallAPI.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService implements UserDetailsService{

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("logdUserByUsername");
		return memberRepository.findByUsername(username).get();
	}
	
	public UserDetails findByEmail(String email) {
        return memberRepository.findByEmail(email).get();
    }
	
	public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
	
	public int signIn(Member member) {
		if(memberRepository.findByUsername(member.getUsername()).isPresent()) {
			return -1;
		}else {
			memberRepository.save(member);
			return 1;
		}
	}
}
