package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Integer>{

	Vehicle findById(int id);
	List<Vehicle> findAll();
	//Vehicle findByFlat(SocietyFlat societyFlat);
	Vehicle findByFlat(SocietyFlat findByFlatNoAndWing);
}
