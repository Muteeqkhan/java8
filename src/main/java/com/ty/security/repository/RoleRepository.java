package com.ty.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.security.models.ERole;
import com.ty.security.models.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByroleName(ERole erole);
	
}
