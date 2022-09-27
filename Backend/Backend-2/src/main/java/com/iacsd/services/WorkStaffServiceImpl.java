package com.iacsd.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iacsd.daos.WorkStaffDao;
import com.iacsd.dtos.Credentials;
import com.iacsd.dtos.OwnerDTO;
import com.iacsd.dtos.WorkStaffDTO;
import com.iacsd.entities.Owner;
import com.iacsd.entities.WorkStaff;
@Transactional
@Service
public class WorkStaffServiceImpl {
	
	@Autowired
	private WorkStaffDao workStaffDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private WorkStaffDTO workStaffDto;
	
	public List<WorkStaff> listOfWorkStaff() {
		return workStaffDao.findAll();
	}
	
	
	public WorkStaff updateWorkStaff(int id, WorkStaffDTO workStaffDto) {
		WorkStaff workStaff = workStaffDao.findById(id);
		workStaff.setAddress(workStaffDto.getAddress());
		workStaff.setContactNo(workStaffDto.getContactNo());
		workStaff.setEmail(workStaffDto.getEmail());
		return workStaff;
		
	}
	
	public WorkStaffDTO findWorkStaffByemail(String email) {
		
		WorkStaff workStaff = workStaffDao.findByEmail(email);
		if(workStaff!=null)
			return workStaffDto.toWorkStaffDto(workStaff);
		else return null;
	}
	
public WorkStaffDTO findStaffByEmailAndPassword(Credentials cred) {
	WorkStaff dbStaff = workStaffDao.findByEmail(cred.getEmail());
	String rawPassword = cred.getPassword();
	if(dbStaff != null && passwordEncoder.matches(rawPassword, dbStaff.getPassword())) {
		WorkStaffDTO result = workStaffDto.toWorkStaffDto(dbStaff);
		result.setPassword("********");
		return result;
	}
	return null;
}

	public WorkStaff saveWorkStaff(WorkStaff workStaff) {
		String rawPassword = workStaff.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		workStaff.setPassword(encPassword);
		return workStaffDao.save(workStaff);
	}
	
	public Map<String, Object> deleteWorkStaff(int ownerId) {
		if(workStaffDao.existsById(ownerId)) {
			workStaffDao.deleteById(ownerId);
			return Collections.singletonMap("affectedRows", 1);
		}
		return Collections.singletonMap("affectedRows", 0);
	}
}
	
