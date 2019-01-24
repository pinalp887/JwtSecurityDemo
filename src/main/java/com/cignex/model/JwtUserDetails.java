package com.cignex.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

	private String token;
	private String userName;
	private Long id;
	private Collection<? extends GrantedAuthority> grantedAuthorities;

	public JwtUserDetails(String token, String userName, long id, List<GrantedAuthority> grantedAuthorities) {
		this.token = token;
		this.userName = userName;
		this.id = id;
		this.grantedAuthorities = grantedAuthorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getToken() {
		return token;
	}

	public String getUserName() {
		return userName;
	}

	public Long getId() {
		return id;
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}
	
}
