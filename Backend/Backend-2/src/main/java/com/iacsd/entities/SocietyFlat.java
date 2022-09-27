package com.iacsd.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="societyflat")
public class SocietyFlat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id;
    @Column(name="wing")
	private String wing;
    @Column(name="flatType")
	private String flatType;
    @Column(name="registerDate")
    @Temporal(TemporalType.DATE)
	private Date registerDate;
    @Column(name="parkingSlot")
	private int parkingSlot;
    @Column(name="flatNo")
	private int flatNo;
    @Column(name="floorNo")
	private int floorNo;
    
    @ManyToOne
    @JoinColumn(name="ownerId")
    private Owner owner;

    @OneToMany(mappedBy="societyflat")
    private List<Visitor> visitor;
    
    @OneToOne(mappedBy="flat")
    private Vehicle vehicle;

    @OneToOne(mappedBy="flat")
    private Maintenance maintenance;
    
    @OneToOne(mappedBy="flat")
    private Tenant tenant;
    
    
    
    public SocietyFlat() {
		super();
	}


	public SocietyFlat(int id, String wing, String flatType, Date registerDate, int parkingSlot, int flatNo,
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

    
	public List<Visitor> getVisitor() {
		return visitor;
	}


	public void setVisitor(List<Visitor> visitor) {
		this.visitor = visitor;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public Maintenance getMaintenance() {
		return maintenance;
	}


	public void setMaintenance(Maintenance maintenance) {
		this.maintenance = maintenance;
	}


	public Tenant getTenant() {
		return tenant;
	}


	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	@Override
	public String toString() {
		return "SocietyFlat [id=" + id + ", wing=" + wing + ", flatType=" + flatType + ", registerDate=" + registerDate
				+ ", parkingSlot=" + parkingSlot + ", flatNo=" + flatNo + ", floorNo=" + floorNo + ", owner=" + owner
				+ ", visitor=" + visitor + ", vehicle=" + vehicle + ", maintenance=" + maintenance + ", tenant="
				+ tenant + "]";
	}


    
    
}
