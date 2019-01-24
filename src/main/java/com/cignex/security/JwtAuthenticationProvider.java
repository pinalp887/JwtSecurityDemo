package com.cignex.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cignex.model.JwtAuthenticationToken;
import com.cignex.model.JwtUser;
import com.cignex.model.JwtUserDetails;
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{
	@Autowired
	private JwtValidator jwtValidator;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthenticationToken authenticationToken=(JwtAuthenticationToken) authentication;
		String token=authenticationToken.getToken();
		JwtUser jwtUser=jwtValidator.validate(token);
		if(jwtUser==null) {
			throw new RuntimeException("Error in Parsing Json Web Token");
		}
		List<GrantedAuthority> grantedAuthorities=AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		return new JwtUserDetails(token,jwtUser.getUserName(),jwtUser.getId(),grantedAuthorities);
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
