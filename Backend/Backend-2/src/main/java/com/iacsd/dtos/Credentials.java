package com.iacsd.dtos;

import org.springframework.stereotype.Component;

import com.iacsd.entities.Owner;
import com.sun.istack.NotNull;
@Component
public class Credentials {
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	
	public Credentials() {
	}
	
	
	public Credentials(String email, String password) {
		this.email = email;
		this.password = password;
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
	
	public OwnerDTO toOwnerDto(Owner entity) {
		OwnerDTO dto = new OwnerDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setMobileNo(entity.getMobileNo());
		return dto;
		
	}
	
	public Owner toUserEntity(OwnerDTO dto) {
		Owner entity = new Owner();
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		return entity;		
	}
	
	@Override
	public String toString() {
		return String.format("Credentials [email=%s, password=%s]", email, password);
	}
	
}
