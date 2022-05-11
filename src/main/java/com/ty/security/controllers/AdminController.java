package com.ty.security.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@PostMapping("/add")
	public String adminAdd() {
		return "add admin method is called";
	}

	@DeleteMapping("/delete")
	public String admindelete() {
		return "delete admin method is called";
	}

	@PostMapping("/update")
	public String adminupdate() {
		return "update admin method is called";
	}

	@GetMapping("/read")
	public String adminread() {
		return "read admin method is called";
	}

}
