package com.ty.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.security.models.ERole;
import com.ty.security.models.Role;
import com.ty.security.repository.RoleRepository;


@Service
public class RoleService {

	
	
	@Autowired
	private RoleRepository role;
	
	public void admin() {
		role.save(new Role(ERole.ROLE_ADMIN));
	}
	public void user() {
		role.save(new Role(ERole.ROLE_USER));
	}
}
