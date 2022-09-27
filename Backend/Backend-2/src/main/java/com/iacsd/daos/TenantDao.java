package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.Tenant;

public interface TenantDao extends JpaRepository<Tenant, Integer> {

	List<Tenant> findAll();
	Tenant save(Tenant tenant);
	Tenant findById(int id);
}
