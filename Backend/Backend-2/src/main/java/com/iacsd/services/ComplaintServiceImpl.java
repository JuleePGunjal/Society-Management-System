package com.iacsd.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.ComplaintDao;
import com.iacsd.daos.OwnerDao;
import com.iacsd.daos.SocietyFlatDao;
import com.iacsd.dtos.ComplaintDTO;
import com.iacsd.dtos.OwnerDTO;
import com.iacsd.entities.Complaint;

@Transactional
@Service
public class ComplaintServiceImpl {
	
	@Autowired
	private ComplaintDao complaintDao;
	
	@Autowired
	private SocietyFlatDao societyFlatDao;
	
	@Autowired
	private OwnerDao ownerDao;
	
	private  ComplaintDTO complaintDto;
	
	public List<Complaint> findAllComplaint()
	{
		return  complaintDao.findAll();
		
	}
	
	public Complaint saveComplaint(ComplaintDTO complaintDto) {
		return complaintDao.save(complaintDto.toComplaintEntity(complaintDto, ownerDao.findById(complaintDto.getOwnerId())));
	}
	
	public ComplaintDTO changeStatus(int id , ComplaintDTO complaintDto) {
		
		Complaint complaint= complaintDao.findById(id);
		complaint.setStatus(complaintDto.getStatus());
		return complaintDto;
		
	}
	public Map<String, Integer> deleteComplaint(int id) {
		if(complaintDao.existsById(id)) {
			complaintDao.deleteById(id);
			return Collections.singletonMap("affectedRows", 1);
		}
		return Collections.singletonMap("affectedRows", 0);
	}

	public List<Complaint> listOfMaintenanceByFlatNo(int flat, String wing) {
		return complaintDao.findByOwner(societyFlatDao.findByFlatNoAndWing(flat, wing).getOwner());
	} 
}
