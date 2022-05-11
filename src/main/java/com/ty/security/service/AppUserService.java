package com.ty.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Registration.Signing;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;
import com.ty.security.models.AppUser;
import com.ty.security.models.ERole;
import com.ty.security.models.Role;
import com.ty.security.repository.AppUserRepository;
import com.ty.security.repository.RoleRepository;
import com.ty.security.requestpojo.SignUpPojo;

@Service
public class AppUserService {

	
	@Autowired
	private AppUserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	
	public boolean saveuser(SignUpPojo signUpPojo) {
		AppUser appUser = new AppUser();
		Set<Role> role=new HashSet<>();
		System.out.println(signUpPojo.getRole());
		
		if(signUpPojo.getRole().isEmpty()) {
			System.err.println("inside if condition");
			Role userrole = roleRepo.findByroleName(ERole.ROLE_USER).orElseThrow(()->new RuntimeException("rolenot found"));
			role.add(userrole);
		}
		else {
			System.err.println("inside else condition");
			signUpPojo.getRole().forEach(rrole->{
				switch(rrole) {
				case "admin":{
					System.err.println("inside case1 condition");
					Role userrole = roleRepo.findByroleName(ERole.ROLE_ADMIN).orElseThrow(()->new RuntimeException("rolenot found"));
					role.add(userrole);
					break;
				}
				default: {
					System.err.println("inside case2 condition");
					Role userrole = roleRepo.findByroleName(ERole.ROLE_USER).orElseThrow(()->new RuntimeException("rolenot found"));
					role.add(userrole);
					break;
				}
				}
			});
		}
		
		System.out.println(role);
		appUser.setRole(role);
		appUser.setEmail(signUpPojo.getEmail());
		appUser.setUserName(signUpPojo.getUserName());
		appUser.setPassword(signUpPojo.getPassword());
		
		try {
			userRepo.save(appUser);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return true;
		
		
		
	}
}
