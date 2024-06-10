package com.java.employeemanagement.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String employeeFirstName;
	
	private String employeeLastName;

	private String employeePhone;
	
	private String employeeEmail;
	
	private boolean isActive;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_designation_id", referencedColumnName = "id")
	private EmployeeDesignation employeeDesignation;
    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_details_id", referencedColumnName = "id")
	private EmployeeDetails employeeDetails;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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


	public EmployeeDesignation getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(EmployeeDesignation employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	}


	
	
