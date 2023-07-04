package com.dev.BLSShoppingMallAPI.model.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="TB_MEMBER")
public class Member implements UserDetails{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MEMBER_ID")
	private Long id;
	
	@Column(name="MEMBER_USERNAME")
	private String username;
	
	@Column(name="MEMBER_PASSWORD")
	private String password;
	
	@Column(name="MEMBER_EMAIL")
	private String email;
	
	@Column(name="MEMBER_PHONE")
	private String phone;
	
	@Column(name="MEMBER_ADDRESS")
	private String address;
	
	@Column(name="MEMBER_ROLE")
	private String roles;
	
	@Column(name="MEMBER_ENABLED")
	private Boolean enabled;
	
	@OneToMany(
			fetch=FetchType.LAZY,
			orphanRemoval = true,
			cascade=CascadeType.ALL,
			mappedBy="memberId"
			)
	private List<MemberLog> memberLogs;
	
	@OneToMany(
			fetch=FetchType.LAZY,
			orphanRemoval = true,
			cascade=CascadeType.ALL,
			mappedBy="memberId"
			)
	private List<MemberTransactionLog> memberTransactionLogs;
	
	@OneToMany(
			fetch=FetchType.LAZY,
			orphanRemoval = true,
			cascade=CascadeType.ALL,
			mappedBy="memberId"
			)
	private List<MemberFile> memberFiles;
	
	@OneToMany(
			fetch=FetchType.LAZY,
			orphanRemoval = true,
			cascade=CascadeType.ALL,
			mappedBy="memberId"
			)
	private List<MemberCart> memberCarts;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(roles));
        return auth;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Override
	public boolean isEnabled() {
		return true;
	}
}
