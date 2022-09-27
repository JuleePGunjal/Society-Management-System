package com.iacsd.dtos;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.iacsd.entities.Owner;

@Component
public class OwnerDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobileNo;
	private Date dob;
	private String gender;
	private String role; 

	
	
	public OwnerDTO() {
		
	}

	public OwnerDTO(int id, String firstName, String lastName, String email, String password, String mobileNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public OwnerDTO toOwnerDto(Owner entity) {
		OwnerDTO dto = new OwnerDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setMobileNo(entity.getMobileNo());
		dto.setDob(entity.getDob());
		dto.setRole(entity.getRole());
		dto.setGender(entity.getGender());
		return dto;
		
	}
	
	public Owner toUserEntity(OwnerDTO dto) {
		Owner entity = new Owner();
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setDob(dto.getDob());
		entity.setRole(dto.getRole().toLowerCase());
		entity.setGender(dto.getGender());
		entity.setMobileNo(dto.getMobileNo());
		return entity;		
	}

	@Override
	public String toString() {
		return "OwnerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", mobileNo=" + mobileNo + ", dob=" + dob + ", gender=" + gender
				+ ", role=" + role + "]";
	}

	
	
	
}
