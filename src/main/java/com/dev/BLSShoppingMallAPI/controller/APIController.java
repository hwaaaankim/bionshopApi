package com.dev.BLSShoppingMallAPI.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.BLSShoppingMallAPI.constant.JwtTokenProvider;
import com.dev.BLSShoppingMallAPI.model.SignModel;
import com.dev.BLSShoppingMallAPI.model.member.Member;
import com.dev.BLSShoppingMallAPI.repository.MemberRepository;
import com.dev.BLSShoppingMallAPI.service.MemberService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class APIController {

	@Autowired
    private MemberService memberService;
	
	@Autowired
	private MemberRepository memberRepository;
	
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
	
    @Bean(name="AuthEncoder")
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
    
	@PostMapping("/loginProcess")
	public Object login(
			@RequestBody Member member
			) {
		
		Optional<Member> result = memberService.findByUsername(member.getUsername());
		SignModel signModel = new SignModel();
		if(result.isPresent()) {
			
			if(!passwordEncoder().matches(member.getPassword(), result.get().getPassword())) {
				signModel.setMember(null);
				signModel.setMessage("INVALID PASSWORD");
				
				return signModel;
			}else {
				
				List<String> roleList = Arrays.asList(result.get().getRoles().split(","));
				signModel.setMember(result.get());
				signModel.setToken(jwtTokenProvider.createToken(result.get().getUsername(), roleList));
				return signModel;
			}
		}else {
			signModel.setMember(null);
			signModel.setMessage("NONE USERNAME");
			
			return signModel;
		}
	}
	
	@PostMapping("/memberRegistration")
	public Object memberRegistration(
			@RequestBody Member signUp
			) {
		Member member = signUp;
		if(signUp.getJob() == 1) {
			member.setRoles("ROLE_MEMBER");
		}else if(signUp.getJob() == 2) {
			member.setRoles("ROLE_DEALER");
		}
		member.setEnabled(true);
		member.setPassword(passwordEncoder().encode(signUp.getPassword()));
		SignModel signModel = new SignModel();
		
		int result = memberService.signIn(member);
		if(result == 1) {
			signModel.setMember(member);
			if(member.getJob() == 2) {
				signModel.setMessage("You need inspection about document you sent. After that \r\n" + 
						"we will sent result to your email or SMS\r\n" + 
						"");
			}else {
				signModel.setMessage("REGISTRATION SUCCESS");
			}
			
			return signModel;
		}else if(result == -1) {
			signModel.setMember(memberService.findByUsername(signUp.getUsername()).get());
			signModel.setMessage("REGISTERED MEMBER");
			
			return signModel;
		}else {
			signModel.setMember(null);
			signModel.setMessage("REGISTRATION FAIL");
			
			return signModel;
		}
		
	}
	
	@PostMapping("/getMemberAuth")
	public Object getMemberAuth(
			HttpServletRequest request
			) {
		String token = jwtTokenProvider.resolveToken(request);
		if(jwtTokenProvider.validateToken(token)) {
			String username = jwtTokenProvider.getUserPk(token);
			
			return memberRepository.findByUsername(username).get().getRoles();
		}else {

			return "INVALID";
		}
		
	}
	
	@PutMapping("/memberInfoUpdate")
	public Object memberInfoUpdate(
			@RequestBody Member signUp
			) {
		return memberService.memberUpdate(signUp);
	}
	
	@PutMapping("/memberPasswordUpdate")
	public Object memberPasswordUpdate(
			@RequestBody Member signUp
			) {
		return memberService.memberPasswordUpdate(signUp);
	}
	
	
	
	@GetMapping("/auth")
	public String auth() {
		
		return "auth";
	}
	
	@GetMapping("/any")
	public String any() {
		
		return "any";
	}
}
