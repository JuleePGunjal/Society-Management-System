package com.iacsd.dtos;

import org.springframework.stereotype.Component;

import com.iacsd.entities.Complaint;
import com.iacsd.entities.Owner;

@Component
public class ComplaintDTO {
	
	private int id;
	private String status;
	private String complaint;
	private int ownerId;
	private String ownerFirstName;
	private String ownerLastName;
	
	
	
	public ComplaintDTO() {
		super();
	}


	public ComplaintDTO(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	

	public int getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getComplaint() {
		return complaint;
	}


	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}


	public String getOwnerFirstName() {
		return ownerFirstName;
	}


	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}


	public String getOwnerLastName() {
		return ownerLastName;
	}


	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}


	

	public ComplaintDTO toComplaintDto(Complaint entity) {
		ComplaintDTO dto = new ComplaintDTO();
		dto.setId(entity.getId());
		dto.setStatus(entity.getStatus());
		dto.setComplaint(entity.getComplaint());
		dto.setOwnerId(entity.getOwner().getId());
		dto.setOwnerFirstName(entity.getOwner().getFirstName());
		dto.setOwnerLastName(entity.getOwner().getLastName());
		return dto;
		
	}
	
	public Complaint toComplaintEntity(ComplaintDTO dto,Owner owner) {
		Complaint entity = new Complaint();
		entity.setId(dto.getId());
		entity.setStatus(dto.getStatus());
		entity.setComplaint(dto.getComplaint());
		entity.setOwner(owner);
		return entity;		
	}


	@Override
	public String toString() {
		return "ComplaintDTO [id=" + id + ", status=" + status + "]";
	}
	
	

}
