package com.ty.security.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.security.models.Role;
import com.ty.security.repository.AppUserRepository;
import com.ty.security.requestpojo.SignUpPojo;
import com.ty.security.service.AppUserService;
import com.ty.security.service.RoleService;

@RestController
@RequestMapping("/appuser")
public class AppUserController {

	@Autowired
	private AppUserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private AppUserRepository repo;

	@GetMapping("/s")
	public void name() {
		roleService.admin();
		roleService.user();
	}

	@PostMapping("/saveuser")
	public boolean saveUser(@RequestBody SignUpPojo signUpPojo) {
		return userService.saveuser(signUpPojo);
	}

	@GetMapping("/get")
	public Set<Role> name1(String user) {

		Set<Role> role = repo.findByuserName(user).get().getRole();
		return role;
	}

}
