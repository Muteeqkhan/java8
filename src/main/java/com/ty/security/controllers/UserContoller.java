package com.ty.security.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserContoller {

	@PostMapping("/add")
	public String adminAdd() {
		return "add user method is called";
	}

	@DeleteMapping("/delete")
	public String admindelete() {
		return "delete user method is called";
	}

	@PostMapping("/update")
	public String adminupdate() {
		return "update user method is called";
	}
	@GetMapping("/read")
	public String adminread() {
		return "read user method is called";
	}

}
