package com.dev.BLSShoppingMallAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dev.BLSShoppingMallAPI.model.member.Member;
import com.dev.BLSShoppingMallAPI.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService implements UserDetailsService{

	
	@Autowired
	MemberRepository memberRepository;
	
	@Bean(name="InfoEncoder")
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
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
	
	public String memberUpdate(Member member) {
		Optional<Member> m = memberRepository.findById(member.getId());
		m.ifPresent(me ->{
			me.setUsername(member.getUsername());
			me.setAddress(member.getAddress());
			me.setEmail(member.getEmail());
			me.setJob(member.getJob());
			me.setName(member.getName());
			me.setPhone(member.getPhone());
			
			memberRepository.save(me);
		});
		
		return "UPDATE SUCCESS";
	}

	public String memberPasswordUpdate(Member member) {
		Optional<Member> m = memberRepository.findById(member.getId());
		m.ifPresent(me ->{
			me.setPassword(passwordEncoder().encode(member.getPassword()));
			
			memberRepository.save(me);
		});
		
		return "UPDATE SUCCESS";
	}
}

















