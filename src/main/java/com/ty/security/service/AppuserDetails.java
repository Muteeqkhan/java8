package com.ty.security.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ty.security.models.AppUser;
import com.ty.security.models.Role;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AppuserDetails implements UserDetails {

	private String userName;
	private String email;
	private String password;
	private Set<Role> role = new HashSet<>();

	public AppuserDetails(AppUser appuser) {
		this.email = appuser.getEmail();
		this.password = appuser.getPassword();
		this.userName = appuser.getUserName();
		this.role = appuser.getRole();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> userRole = new HashSet<>();
		this.role.forEach(r -> {
			userRole.add(new SimpleGrantedAuthority(r.getRoleName().name()));
			System.out.println(r.getRoleName());
		});
		System.err.println(userRole);
		return userRole;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
