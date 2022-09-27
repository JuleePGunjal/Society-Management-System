package com.iacsd.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iacsd.daos.OwnerDao;
import com.iacsd.daos.SocietyFlatDao;
import com.iacsd.dtos.Credentials;
import com.iacsd.dtos.OwnerDTO;
import com.iacsd.dtos.Response;
import com.iacsd.entities.Owner;
import com.iacsd.entities.SocietyFlat;
@Transactional
@Service
public class OwnerServiceImpl {

	@Autowired
	private OwnerDao ownerDao;
	
	@Autowired
	private OwnerDTO ownerDto;
	
	@Autowired
	private SocietyFlatDao societyFlatDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public Owner findOwnerById(int id) {
		
		Owner owner = ownerDao.findById(id);
		if(owner!=null)
			return owner;
		else return null;
	}
	
	public OwnerDTO findOwnerByemail(String email) {
		
		Owner owner = ownerDao.findByEmail(email);
		if(owner!=null)
			return ownerDto.toOwnerDto(owner);
		else return null;
	}
	
public OwnerDTO findUserByEmailAndPassword(Credentials cred) {
	Owner dbOwner = ownerDao.findByEmail(cred.getEmail());
	String rawPassword = cred.getPassword();
	if(dbOwner != null && passwordEncoder.matches(rawPassword, dbOwner.getPassword())) {
		OwnerDTO result = ownerDto.toOwnerDto(dbOwner);
		result.setPassword("********");
		return result;
	}
	return null;
}



	public List<Owner> findAllOwner() {
		return ownerDao.findAll();
	}
	
	
	public OwnerDTO saveOwner(OwnerDTO userDto) {
		String rawPassword = userDto.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		userDto.setPassword(encPassword);
		Owner owner = ownerDto.toUserEntity(userDto);
		owner = ownerDao.save(owner);
		userDto = ownerDto.toOwnerDto(owner);
		userDto.setPassword("*******");
		return userDto;
	}
	
	public OwnerDTO updateOwner(int id ,OwnerDTO ownerDto) {
	
		Owner owner = ownerDao.findById(id);
		owner.setMobileNo(ownerDto.getMobileNo());
		owner.setEmail(ownerDto.getEmail());
        owner = ownerDao.save(owner);
		ownerDto = ownerDto.toOwnerDto(owner);
		ownerDto.setPassword("*******");
		return ownerDto;
	}
	
	public OwnerDTO changePassword(int id ,OwnerDTO ownerDto) {
		
		Owner owner = ownerDao.findById(id);
		String rawPassword = ownerDto.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		owner.setPassword(encPassword);
        owner = ownerDao.save(owner);
		ownerDto = ownerDto.toOwnerDto(owner);
		ownerDto.setPassword("*******");
		return ownerDto;
	}
	
	public OwnerDTO updateOwnerByAdmin(int id , OwnerDTO ownerDto) {
		Owner owner = ownerDao.findById(id);
		owner.setMobileNo(ownerDto.getMobileNo());
		owner.setEmail(ownerDto.getEmail());
		owner.setFirstName(ownerDto.getFirstName());
		owner.setLastName(ownerDto.getLastName());
		owner.setRole(ownerDto.getRole());
		owner.setGender(ownerDto.getGender());
		owner.setDob(ownerDto.getDob());
		owner.setPassword(ownerDto.getPassword());
		owner = ownerDao.save(owner);
		ownerDto = ownerDto.toOwnerDto(owner);
		ownerDto.setPassword("*******");
		return ownerDto;
	}
	
	
	public Map<String, Integer> deleteOwner(int ownerId) {
		if(ownerDao.existsById(ownerId)) {
			ownerDao.deleteById(ownerId);
			return Collections.singletonMap("affectedRows", 1);
		}
		return Collections.singletonMap("affectedRows", 0);
	}
	
	public Owner getOwnerFlatNo(int flatNo) {
		SocietyFlat flat = societyFlatDao.findByFlatNo(flatNo);
		return flat.getOwner();
	}

	public List<OwnerDTO> getOwnerFloorNo(int floorNo, String wing) {
		List<SocietyFlat> flatList = societyFlatDao.findByFloorNoAndWing(floorNo,wing);
		List<OwnerDTO> ownerList = new ArrayList();
		for(SocietyFlat flat : flatList) {
			OwnerDTO owner = ownerDto.toOwnerDto(flat.getOwner());
			owner.setPassword("**********");
			ownerList.add(owner);
		}
		return ownerList;
	}
}
