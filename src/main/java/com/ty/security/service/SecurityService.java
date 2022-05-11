package com.ty.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ty.security.models.AppUser;
import com.ty.security.repository.AppUserRepository;

@Service
public class SecurityService  implements UserDetailsService{

	@Autowired
	AppUserRepository appUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser findByuserName = appUserRepository.findByuserName(username).
				orElseThrow(()->new RuntimeException("could not find the user"));
		
		
		return new AppuserDetails(findByuserName);
	}

}
