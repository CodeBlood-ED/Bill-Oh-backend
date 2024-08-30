package com.billoh.billohmicroservices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billoh.billohmicroservices.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByName(String name);
	
}
