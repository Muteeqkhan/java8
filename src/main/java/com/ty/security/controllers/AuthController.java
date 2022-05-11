package com.ty.security.controllers;

import java.util.Collection;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.security.exceptions.LoginFailException;
import com.ty.security.jwt.JwtUtil;
import com.ty.security.requestpojo.LoginRequest;
import com.ty.security.responsepojo.JWTResponse;
import com.ty.security.service.AppuserDetails;

@RestController
public class AuthController {

	@Autowired
	JwtUtil jwtutil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest login) {
		Authentication authenticate=null;
		
		try {
			 authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));
		} catch (AuthenticationException e) {
			throw new LoginFailException("chal bhag");
		}
		
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		
		String jwt=jwtutil.generateJwtToken(authenticate);
		AppuserDetails principal = (AppuserDetails)authenticate.getPrincipal();
		Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
		System.out.println(authorities);
		Set<String> role=new HashSet<>();
		authorities.forEach(x->{
			role.add(x.getAuthority());
		});
		
		return ResponseEntity.ok(new JWTResponse(jwt,principal.getUsername(),role));
		
	}
}
