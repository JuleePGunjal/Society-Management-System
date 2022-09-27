package com.iacsd.dtos;


import org.springframework.stereotype.Component;

import com.iacsd.entities.SocietyFlat;
import com.iacsd.entities.Vehicle;

@Component
public class VehicleDTO {

	private int id;
	private String vehicleNo;
	private int flatId; 
	private int flatNo;
	private int floorNo;
	private String wing;
	private String ownerFirstName;
	private String ownerLastName;
	
	
	public VehicleDTO() {
		super();
	}
	
	
	public VehicleDTO(int id, String vehicleNo) {
		super();
		this.id = id;
		this.vehicleNo = vehicleNo;
	}
	
	
	
	public int getFlatNo() {
		return flatNo;
	}


	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
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


	public String getVehicleNo() {
		return vehicleNo;
	}
	
	
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	
	public VehicleDTO toVehicleDto(Vehicle entity) {
		VehicleDTO dto = new VehicleDTO();
		dto.setId(entity.getId());
		dto.setVehicleNo(entity.getVehicleNo());
		dto.setFlatId(entity.getFlat().getId());
		dto.setFlatNo(entity.getFlat().getFlatNo());
		dto.setFloorNo(entity.getFlat().getFloorNo());
		dto.setWing(entity.getFlat().getWing());
		dto.setOwnerFirstName(entity.getFlat().getOwner().getFirstName());
		dto.setOwnerLastName(entity.getFlat().getOwner().getLastName());
		return dto;
		
	}
	
	public Vehicle toVehicleEntity(VehicleDTO dto , SocietyFlat flat) {
		Vehicle entity = new Vehicle();
		entity.setVehicleNo(dto.getVehicleNo());
		entity.setFlat(flat);
		return entity;		
	}
	
	@Override
	public String toString() {
		return "VehicleDto [id=" + id + ", vehicleNo=" + vehicleNo + "]";
	}
	
}
