package com.iacsd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="complaint")
public class Complaint {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
	private int id;
@Column(name="complaint")
	private String complaint;
@Column(name="status")
private String status;

@ManyToOne
@JoinColumn(name="ownerId")
private Owner owner;


public Complaint() {
	super();
}

public Complaint(int id, String complaint, String status) {
	super();
	this.id = id;
	this.complaint = complaint;
	this.status = status;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getComplaint() {
	return complaint;
}

public void setComplaint(String complaint) {
	this.complaint = complaint;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Owner getOwner() {
	return owner;
}

public void setOwner(Owner owner) {
	this.owner = owner;
}

@Override
public String toString() {
	return "Complaint [id=" + id + ", complaint=" + complaint + ", status=" + status + ", owner=" + owner + "]";
}


}
