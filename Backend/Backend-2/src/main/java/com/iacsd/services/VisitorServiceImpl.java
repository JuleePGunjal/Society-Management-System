package com.iacsd.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.SocietyFlatDao;
import com.iacsd.daos.VisitorDao;
import com.iacsd.entities.Visitor;

@Transactional
@Service 
public class VisitorServiceImpl {
	
	@Autowired
	private VisitorDao visitorDao;
	
	@Autowired
	private SocietyFlatDao societyFlatDao;
	
	public List<Visitor> findAllVisitor(){
		return visitorDao.findAll();
	}
	
	public Map<String, Object> deleteVisitor(int id) {
		if(visitorDao.existsById(id)) {
			visitorDao.deleteById(id);
			return Collections.singletonMap("affectedRows", 1);
		}
		return Collections.singletonMap("affectedRows", 0);
	}
	
	public Visitor saveVisitor(Visitor visitor) {
		return visitorDao.save(visitor);
	}
	
	public Visitor VisByName(String name) {
		return visitorDao.findByName(name);
	}

	public Visitor listOfVisitorByFlatNo(int flat, String wing) {
		return visitorDao.findBySocietyflat(societyFlatDao.findByFlatNoAndWing(flat, wing));
	}

}
