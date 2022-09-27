package com.iacsd.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="visitor")
public class Visitor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
	private int id;
@Column(name="name")
	private String name;
@Column(name="contactNo")
	private String contactNo;
@Column(name="inTime",insertable = false ,updatable = false)
//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime inTime;

@ManyToOne
@JoinColumn(name="flatId")
private SocietyFlat societyflat;



public Visitor() {
	super();
}

public Visitor(int id, String name, String contactNo, LocalDateTime inTime) {
	super();
	this.id = id;
	this.name = name;
	this.contactNo = contactNo;
	this.inTime = inTime;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public LocalDateTime getInTime() {
	return inTime;
}

public void setInTime(LocalDateTime inTime) {
	this.inTime = inTime;
}

public SocietyFlat getSocietyflat() {
	return societyflat;
}

public void setSocietyflat(SocietyFlat societyflat) {
	this.societyflat = societyflat;
}

@Override
public String toString() {
	return "Visitor [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", inTime=" + inTime + ", societyflat="
			+ societyflat + "]";
}



}
