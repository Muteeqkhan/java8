package com.ty.security.responsepojo;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTResponse {

	private String token;
	private String userName;
	private Set<String> roles=new HashSet<>();
}
