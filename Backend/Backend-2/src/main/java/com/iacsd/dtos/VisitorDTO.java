package com.iacsd.dtos;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Visitor;

@Component
public class VisitorDTO {
	
	private int id;
	private String contactNo;
	private String name;
	private LocalDateTime inTime;
	private int flatId;
	private int flatNo;
	private int floorNo;
	private String wing;
	private String ownerFirstName;
	private String ownerLastName;
	
	public LocalDateTime getInTime() {
		return inTime;
	}
	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public VisitorDTO() {
		super();
	}
	public VisitorDTO(int id, String contactNo, String name) {
		super();
		this.id = id;
		this.contactNo = contactNo;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatId) {
		this.flatId = flatId;
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
	
	
	
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public String getWing() {
		return wing;
	}
	public void setWing(String wing) {
		this.wing = wing;
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
	@Override
	public String toString() {
		return "VisitorDTO [id=" + id + ", contactNo=" + contactNo + ", name=" + name + "]";
	}
	
	public VisitorDTO toVisitorDto(Visitor entity) {
		VisitorDTO dto = new VisitorDTO();
		dto.setId(entity.getId());
		dto.setContactNo(entity.getContactNo());
		dto.setName(entity.getName());
		dto.setInTime(entity.getInTime());
		dto.setWing(entity.getSocietyflat().getWing());
		dto.setFloorNo(entity.getSocietyflat().getFloorNo());
		dto.setFlatNo(entity.getSocietyflat().getFlatNo());
		dto.setOwnerFirstName(entity.getSocietyflat().getOwner().getFirstName());
		dto.setOwnerLastName(entity.getSocietyflat().getOwner().getLastName());
		return dto;
		
	}
	
	public Visitor toVisitorEntity(VisitorDTO dto ,  SocietyFlat flat) {
		Visitor entity = new Visitor();
		entity.setId(dto.getId());
		entity.setContactNo(dto.getContactNo());
		entity.setName(dto.getName());
		entity.setSocietyflat(flat);
		return entity;		
	}
}
