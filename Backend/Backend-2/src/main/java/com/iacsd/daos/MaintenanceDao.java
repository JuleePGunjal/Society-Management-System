package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.Maintenance;
import com.iacsd.entities.SocietyFlat;

public interface MaintenanceDao extends JpaRepository<Maintenance, Integer> {
	
List<Maintenance> findAll();
 Maintenance findById(int id);
List<Maintenance> findByFlat(SocietyFlat flat);

}