package com.iacsd.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.OwnerDao;
import com.iacsd.daos.SocietyFlatDao;
import com.iacsd.dtos.OwnerDTO;
import com.iacsd.dtos.SocietyFlatDTO;
import com.iacsd.entities.Complaint;
import com.iacsd.entities.Owner;
import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Vehicle;

@Transactional
@Service
public class SocietyFlatServiceImpl {

	@Autowired
	private SocietyFlatDao societyFlatDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private SocietyFlatDTO societyFlatDto;
	
	public List<SocietyFlat> findAllFlat() {
		return societyFlatDao.findAll();
	}
	
	public SocietyFlat findAllFlat(int id) {
		return societyFlatDao.findById(id);
	}

	public SocietyFlat addOwnerToFlat(SocietyFlatDTO societyFlatDto) {
		SocietyFlat flat = societyFlatDao.findByFlatNoAndWing(societyFlatDto.getFlatNo(), societyFlatDto.getWing());
		Owner owner = ownerDao.findById(societyFlatDto.getId());
		flat.setOwner(owner);
		return societyFlatDao.save(flat);
	}
	
	public SocietyFlat removeOwnerToFlat(SocietyFlatDTO societyFlatDto) {
		SocietyFlat flat = societyFlatDao.findByFlatNoAndWing(societyFlatDto.getFlatNo(), societyFlatDto.getWing());
		flat.setOwner(null);
		return societyFlatDao.save(flat);
	}

	
	}
	

