package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.SocietyFlat;

public interface SocietyFlatDao extends JpaRepository<SocietyFlat, Integer>{
	
	SocietyFlat findById(int id);
	List<SocietyFlat> findAll();
	SocietyFlat findByFlatNo(int flatNo);
	List<SocietyFlat> findByFloorNoAndWing(int floorNo,String wing);
	SocietyFlat findByFlatNoAndWing(int flatNo,String wing);
}
