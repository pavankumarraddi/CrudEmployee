package com.java.employeemanagement.model.dto;

import lombok.Data;

@Data
public class EmployeeDetailsReq {

	private Integer id;
	
	private String fatherName;
	
	private String motherName;
	
	private String city;
	
	private String country;
	
    private String address;
    
    private Integer pincode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	private boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
