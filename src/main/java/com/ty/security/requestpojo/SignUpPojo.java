package com.ty.security.requestpojo;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class SignUpPojo {

	private String userName;
	private String email;
	private String password;
	private Set<String> role = new HashSet<>();
}
