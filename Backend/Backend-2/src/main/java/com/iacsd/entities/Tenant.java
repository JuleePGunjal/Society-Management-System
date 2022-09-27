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
@Table(name="tenant")
public class Tenant {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
	private int id;
@Column(name="firstName")
	private String firstName;
@Column(name="lastName")
private String lastName;
@Column(name="contactNo")
private String contactNo;
@Column(name="gender")
private String gender;
@Column(name="email")
private String email;

@OneToOne
@JoinColumn(name="flatId")
private SocietyFlat flat;



public Tenant() {
	super();
}

public Tenant(int id, String firstName, String lastName, String contactNo, String gender, String email) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.contactNo = contactNo;
	this.gender = gender;
	this.email = email;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



public SocietyFlat getFlat() {
	return flat;
}

public void setFlat(SocietyFlat flat) {
	this.flat = flat;
}

@Override
public String toString() {
	return "Tenant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
			+ ", gender=" + gender + ", email=" + email + ", societyFlat=" + flat + "]";
}


}
