package com.iacsd.dtos;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.iacsd.entities.SocietyFlat;



@Component
public class SocietyFlatDTO {
	
	private int id;
	private String wing;
    private String flatType;
    private Date registerDate;
    private int parkingSlot;
    private int flatNo;
    private int floorNo;
    private String ownerFirstName;
    private String ownerLastName;
    private VehicleDTO vehicle;
    
	public SocietyFlatDTO() {
		super();
	}
	public SocietyFlatDTO(int id, String wing, String flatType, Date registerDate, int parkingSlot, int flatNo,
			int floorNo) {
		super();
		this.id = id;
		this.wing = wing;
		this.flatType = flatType;
		this.registerDate = registerDate;
		this.parkingSlot = parkingSlot;
		this.flatNo = flatNo;
		this.floorNo = floorNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWing() {
		return wing;
	}
	
	
	public VehicleDTO getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleDTO vehicleDto) {
		this.vehicle = vehicleDto;
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
	public void setWing(String wing) {
		this.wing = wing;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public int getParkingSlot() {
		return parkingSlot;
	}
	public void setParkingSlot(int parkingSlot) {
		this.parkingSlot = parkingSlot;
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
	public SocietyFlatDTO toSocietyFlatDto(SocietyFlat entity) {
		SocietyFlatDTO dto = new SocietyFlatDTO();
		dto.setId(entity.getId());
		dto.setFlatNo(entity.getFlatNo());;
		dto.setFlatType(entity.getFlatType());
		dto.setFloorNo(entity.getFloorNo());;
		dto.setWing(entity.getWing());
		dto.setParkingSlot(entity.getParkingSlot());
		dto.setRegisterDate(entity.getRegisterDate());
		if(entity.getOwner()!=null) {
			dto.setOwnerFirstName(entity.getOwner().getFirstName());
			dto.setOwnerLastName(entity.getOwner().getLastName());
		}
		VehicleDTO vdto = new VehicleDTO();
		if(entity.getVehicle() != null)
			dto.setVehicle(vdto.toVehicleDto(entity.getVehicle()));
		else dto.setVehicle(new VehicleDTO());
		return dto;
		
	}
	
	public SocietyFlat toSocietyFlatEntity(SocietyFlatDTO dto) {
		SocietyFlat entity = new SocietyFlat();
		entity.setId(dto.getId());
		entity.setFlatNo(dto.getFlatNo());;
		entity.setFlatType(dto.getFlatType());
		entity.setFloorNo(dto.getFloorNo());;
		entity.setWing(dto.getWing());
		entity.setParkingSlot(dto.getParkingSlot());
		entity.setRegisterDate(dto.getRegisterDate());
		return entity;		
	}
	
	@Override
	public String toString() {
		return "SocietyFlatDTO [id=" + id + ", wing=" + wing + ", flatType=" + flatType + ", registerDate="
				+ registerDate + ", parkingSlot=" + parkingSlot + ", flatNo=" + flatNo + ", floorNo=" + floorNo + "]";
	}
    
    

}
