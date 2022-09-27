package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.Owner;

public interface OwnerDao extends JpaRepository<Owner, Integer>{

	Owner findById(int id);
	Owner findByEmail(String email);
	List<Owner> findAll();
	Owner save(Owner owner);
	
	
}
