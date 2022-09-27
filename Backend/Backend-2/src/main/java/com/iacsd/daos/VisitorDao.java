package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Visitor;

public interface VisitorDao extends JpaRepository<Visitor, Integer>{
	
 Visitor findByName(String name);

Visitor findBySocietyflat(SocietyFlat findByFlatNoAndWing);
}
