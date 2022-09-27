package com.iacsd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="workstaff")
public class WorkStaff {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
	private int id;
@Column(name="name ")
	private String name ;
@Column(name="password ")
private String password ;
@Column(name="monthSalary  ")
private String monthSalary  ;
@Column(name="address ")
private String address ;

@Column(name="role ")
private String role ;
@Column(name="contactNo")
private String contactNo;
@Column(name="email")
private String email;



public WorkStaff() {
	super();
}
public WorkStaff(int id, String name, String password, String monthSalary, String address, String role,
		String contactNo, String email) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.monthSalary = monthSalary;
	this.address = address;
	this.role = role;
	this.contactNo = contactNo;
	this.email = email;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMonthSalary() {
	return monthSalary;
}
public void setMonthSalary(String monthSalary) {
	this.monthSalary = monthSalary;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "WorkStaff [id=" + id + ", name=" + name + ", password=" + password + ", monthSalary=" + monthSalary
			+ ", address=" + address + ", role=" + role + ", contactNo=" + contactNo + ", email=" + email + "]";
}



}
