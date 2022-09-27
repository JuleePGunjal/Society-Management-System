package com.iacsd.dtos;


import org.springframework.stereotype.Component;

import com.iacsd.entities.Owner;
import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Tenant;
import com.iacsd.services.SocietyFlatServiceImpl;

@Component
public class TenantDTO {
	

	
	private int id;
	private String contactNo;
	private String email;
	private String firstName;
	private String lastName;
	private String ownerfirstName;
	private String ownerlastName;
	private int floorNo;
	private int flatNo;
	private String wing;
	private int flatId;
	
	
	public TenantDTO() {
		super();
	}
	
	
	public TenantDTO(int id, String contactNo, String email) {
		super();
		this.id = id;
		this.contactNo = contactNo;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getOwnerfirstName() {
		return ownerfirstName;
	}


	public void setOwnerfirstName(String ownerfirstName) {
		this.ownerfirstName = ownerfirstName;
	}


	public String getOwnerlastName() {
		return ownerlastName;
	}


	public void setOwnerlastName(String ownerlastName) {
		this.ownerlastName = ownerlastName;
	}


	public int getFloorNo() {
		return floorNo;
	}


	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}


	public int getFlatNo() {
		return flatNo;
	}


	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}


	public String getWing() {
		return wing;
	}


	public void setWing(String wing) {
		this.wing = wing;
	}


	public int getFlatId() {
		return flatId;
	}


	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public TenantDTO toTenantDto(Tenant entity) {
		TenantDTO dto = new TenantDTO();
		dto.setId(entity.getId());
		dto.setEmail(entity.getEmail());
		dto.setContactNo(entity.getContactNo());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setFlatNo(entity.getFlat().getFlatNo());
		dto.setFloorNo(entity.getFlat().getFloorNo());
        dto.setFlatId(entity.getFlat().getId());
        dto.setWing(entity.getFlat().getWing());
        dto.setOwnerfirstName(entity.getFlat().getOwner().getFirstName());
		dto.setOwnerlastName(entity.getFlat().getOwner().getLastName());
		return dto;
		
	}
	
	public Tenant toTenantEntity(TenantDTO dto,SocietyFlat flat) {
		Tenant entity = new Tenant();
		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setContactNo(dto.getContactNo());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setFlat(flat);
		return entity;		
	}

	@Override
	public String toString() {
		return "TenantDTO [id=" + id + ", contactNo=" + contactNo + ", email=" + email + "]";
	}
	
	
	

}
