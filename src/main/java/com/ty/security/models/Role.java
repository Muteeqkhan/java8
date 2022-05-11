package com.ty.security.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

	public Role(ERole ole){
		this.roleName=ole;   
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;
	@Enumerated(EnumType.STRING)
	private ERole roleName;
}
