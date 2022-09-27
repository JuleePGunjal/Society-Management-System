package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.Owner;
import com.iacsd.entities.WorkStaff;

public interface WorkStaffDao extends JpaRepository<WorkStaff, Integer> {
	
	List<WorkStaff> findAll();
	
	WorkStaff findById(int id);
	
	WorkStaff findByEmail(String email);
}
	
	
