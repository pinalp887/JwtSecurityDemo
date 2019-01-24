package com.cignex.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.model.JwtUser;
import com.cignex.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	private JwtGenerator jwtGenerator; 
	
	@PostMapping
	private String generate(@RequestBody JwtUser jwtUser) { 
			return jwtGenerator.generate(jwtUser);
	}
}
