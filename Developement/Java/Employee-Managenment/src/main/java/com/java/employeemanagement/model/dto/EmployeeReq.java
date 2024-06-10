package com.java.employeemanagement.model.dto;

import lombok.Data;

@Data
public class EmployeeReq {
    
	private Integer id;
	
	private String employeeFirstName;
	
	private String employeeLastName;
	
	private String employeeEmail;
	
    private String employeePhone;
    
    private Integer employeeDesignationId;
    
    private Integer employeeDetailsId;
    
    
    public Integer getEmployeeDetailsId() {
		return employeeDetailsId;
	}
	public void setEmployeeDetailsId(Integer employeeDetailsId) {
		this.employeeDetailsId = employeeDetailsId;
	}
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


