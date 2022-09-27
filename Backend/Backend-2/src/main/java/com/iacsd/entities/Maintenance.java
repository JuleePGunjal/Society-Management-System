package com.iacsd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="maintenance")
public class Maintenance {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
	private int id;
@Column(name="month")
	private String month;
@Column(name="flatMaintenance")
private double flatMaintenance;
@Column(name="waterBill ")
private double waterBill ;
@Column(name="parkingBill ")
private double parkingBill ;
@Column(name="others  ")
private double others  ;

@OneToOne
@JoinColumn(name="flatId")
private SocietyFlat flat;



public Maintenance() {
	super();
}

public Maintenance(int id, String month, double flatMaintenance, double waterBill, double parkingBill,
		double others) {
	super();
	this.id = id;
	this.month = month;
	this.flatMaintenance = flatMaintenance;
	this.waterBill = waterBill;
	this.parkingBill = parkingBill;
	
	this.others = others;
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

public double getFlatMaintenance() {
	return flatMaintenance;
}

public void setFlatMaintenance(double flatMaintenance) {
	this.flatMaintenance = flatMaintenance;
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



public double getOthers() {
	return others;
}

public void setOthers(double others) {
	this.others = others;
}

public SocietyFlat getFlat() {
	return flat;
}

public void setFlat(SocietyFlat flat) {
	this.flat = flat;
}

@Override
public String toString() {
	return "Maintenance [id=" + id + ", month=" + month + ", flatMaintenance=" + flatMaintenance + ", waterBill="
			+ waterBill + ", parkingBill=" + parkingBill + ", others=" + others + ", flat=" + flat
			+ "]";
}


}
