package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.Complaint;
import com.iacsd.entities.Owner;
import com.iacsd.entities.SocietyFlat;

public interface ComplaintDao extends JpaRepository<Complaint, Integer> {

	List<Complaint> findAll();
	Complaint findById(int id);
	List<Complaint> findByOwner(Owner owner);
}
