package com.iacsd.dtos;

import org.springframework.stereotype.Component;

import com.iacsd.entities.WorkStaff;

@Component
public class WorkStaffDTO {

	private int id;
	private String address;
	private String contactNo;
	private String email;
	private String name;
	private String monthSalary;
	private String password;
	private String role;
	
	
	public WorkStaffDTO() {
		super();
	}

	public WorkStaffDTO(int id, String address, String contactNo, String email, String name, String monthSalary,
			String password, String role) {
		super();
		this.id = id;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.name = name;
		this.monthSalary = monthSalary;
		this.password = password;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getMonthSalary() {
		return monthSalary;
	}


	public void setMonthSalary(String monthSalary) {
		this.monthSalary = monthSalary;
	}


	public WorkStaffDTO toWorkStaffDto(WorkStaff entity) {
		WorkStaffDTO dto = new WorkStaffDTO();
		dto.setId(entity.getId());
		dto.setAddress(entity.getAddress());
		dto.setName(entity.getName());;
		dto.setContactNo(entity.getContactNo());
		dto.setEmail(entity.getEmail());
		dto.setMonthSalary(entity.getMonthSalary());
		dto.setPassword("***********");
		dto.setRole(entity.getRole());
		return dto;
		
	}
	
	public WorkStaff toWorkStaffEntity(WorkStaffDTO dto) {
		WorkStaff entity = new WorkStaff();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setContactNo(dto.getContactNo());
		entity.setEmail(dto.getEmail());
		entity.setMonthSalary(dto.getMonthSalary());
		entity.setRole(dto.getRole().toLowerCase());
		entity.setPassword(dto.getPassword());
		return entity;		
	}

	@Override
	public String toString() {
		return "WorkStaffDTO [id=" + id + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email
				+ "]";
	}
	
	
	
	
}
