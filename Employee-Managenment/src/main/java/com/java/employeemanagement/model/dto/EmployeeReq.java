package com.java.employeemanagement.model.dto;

import com.java.employeemanagement.model.EmployeeDesignation;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class EmployeeReq {
    

	private Integer id;
	
	private String employeeFirstName;
	
	private String employeeLastName;
	
	private String employeeEmail;
	
    private String employeePhone;
    
    private Integer employeeDesignationId;
    
    private Integer employee_Details_Id;

	private String fatherName;
		
	private String motherName;
		
	private String address;
		
	private String city;
		
	private String country;
		
	private Integer pincode;
	
	private EmployeeDesignation EmpDesig;
	
	

	
	public EmployeeDesignation getEmpDesig() {
		return EmpDesig;
	}

	public void setEmpDesig(EmployeeDesignation empDesig) {
		EmpDesig = empDesig;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
    
    
public Integer getEmployee_Details_Id() {
		return employee_Details_Id;
	}

	public void setEmployee_Details_Id(Integer employee_Details_Id) {
		this.employee_Details_Id = employee_Details_Id;
	}


	//    public Integer getEmployeeDetailsId() {
//		return employeeDetailsId;
//	}
//	public void setEmployeeDetailsId(Integer employeeDetailsId) {
//		this.employeeDetailsId = employeeDetailsId;
//	}
	private boolean isActive;
	
	public Integer getEmployeeDesignationId() {
		return employeeDesignationId;
	}
	public void setEmployeeDesignationId(Integer employeeDesignationId) {
		this.employeeDesignationId = employeeDesignationId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	
    public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	 // Include this if you want to set this from the request
    
//   public String getEmployeeDetailsById(int id) {
//		return employeeDetails ;
//   }
}


