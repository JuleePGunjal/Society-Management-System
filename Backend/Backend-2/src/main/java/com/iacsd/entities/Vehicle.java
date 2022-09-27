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
@Table(name="vehicle")
public class Vehicle {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
	private int id;
@Column(name="vehicleNo")
	private String vehicleNo;

@OneToOne
@JoinColumn(name="flatId")
private SocietyFlat flat;


public Vehicle() {
	super();
}


public Vehicle(int id, String vehicleNo, SocietyFlat flat) {
	super();
	this.id = id;
	this.vehicleNo = vehicleNo;
	this.flat = flat;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getVehicleNo() {
	return vehicleNo;
}


public void setVehicleNo(String vehicleNo) {
	this.vehicleNo = vehicleNo;
}


public SocietyFlat getFlat() {
	return flat;
}


public void setFlat(SocietyFlat flat) {
	this.flat = flat;
}


@Override
public String toString() {
	return "Vehicle [id=" + id + ", vehicleNo=" + vehicleNo +  "]";
}


}
