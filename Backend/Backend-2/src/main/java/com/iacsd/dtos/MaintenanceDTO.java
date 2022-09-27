package com.iacsd.dtos;

import org.springframework.stereotype.Component;

import com.iacsd.entities.Maintenance;
import com.iacsd.entities.Owner;
import com.iacsd.entities.SocietyFlat;

@Component
public class MaintenanceDTO {

	private int id;
	private String month;
	private double waterBill;
	private double parkingBill;
	private double flatMaintenance;
	private double others;
	private int flatId;
	private double total;
	private int flatNo;
	private int floorNo;
	private String wing;
	private String ownerFirstName;
	private String ownerLastName;

	
	public MaintenanceDTO(int id, String month, double waterBill, double parkingBill, double flatMaintenance, 
			double other) {
		super();
		this.id = id;
		this.month = month;
		this.waterBill = waterBill;
		this.parkingBill = parkingBill;
		this.flatMaintenance = flatMaintenance;
		this.others = other;
	}

	public MaintenanceDTO() {
		super();
	}

	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public double getWaterBill() {
		return waterBill;
	}

	public void setWaterBill(double waterBill) {
		this.waterBill = waterBill;
	}

	public double getParkingBill() {
		return parkingBill;
	}

	public void setParkingBill(double parkingBill) {
		this.parkingBill = parkingBill;
	}

	public double getFlatMaintenance() {
		return flatMaintenance;
	}

	public void setFlatMaintenance(double flatMaintenance) {
		this.flatMaintenance = flatMaintenance;
	}

	

	public double getOthers() {
		return others;
	}

	public void setOthers(double others) {
		this.others = others;
	}
	public MaintenanceDTO toMaintenanceDto(Maintenance entity) {
		MaintenanceDTO dto = new MaintenanceDTO();
		dto.setId(entity.getId());
		dto.setMonth(entity.getMonth());
		dto.setFlatMaintenance(entity.getFlatMaintenance());
		dto.setParkingBill(entity.getParkingBill());
		dto.setWaterBill(entity.getWaterBill());
		dto.setOthers(entity.getOthers());
		dto.setFlatId(entity.getFlat().getId());
		dto.setOwnerFirstName(entity.getFlat().getOwner().getFirstName());
		dto.setOwnerLastName(entity.getFlat().getOwner().getLastName());
		dto.setFlatNo(entity.getFlat().getFlatNo());
		dto.setFloorNo(entity.getFlat().getFloorNo());
		dto.setWing(entity.getFlat().getWing());
		dto.setTotal(entity.getFlatMaintenance() + entity.getParkingBill() + entity.getWaterBill() + entity.getOthers());
		return dto;
		
	}
	
	public Maintenance toMaintenanceEntity(MaintenanceDTO dto,SocietyFlat flat) {
		Maintenance entity = new Maintenance();
		entity.setId(dto.getId());
		entity.setMonth(dto.getMonth());
		entity.setFlatMaintenance(dto.getFlatMaintenance());
		entity.setParkingBill(dto.getParkingBill());
		entity.setWaterBill(dto.getWaterBill());
		entity.setOthers(dto.getOthers());
		entity.setFlat(flat);
		return entity;		
	}

	@Override
	public String toString() {
		return "MaintenanceDTO [id=" + id + ", month=" + month + ", waterBill=" + waterBill + ", parkingBill="
				+ parkingBill + ", flatMaintenance=" + flatMaintenance + ", others=" + others + "]";
	}

	
}
