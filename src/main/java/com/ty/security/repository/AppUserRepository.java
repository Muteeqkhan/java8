package com.ty.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.security.models.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

	Optional<AppUser> findByuserName(String user);

}
