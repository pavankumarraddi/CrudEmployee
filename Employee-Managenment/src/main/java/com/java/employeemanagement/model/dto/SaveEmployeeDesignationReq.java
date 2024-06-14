package com.java.employeemanagement.model.dto;

import lombok.Data;

@Data
public class SaveEmployeeDesignationReq {
	private Integer employeeDesigntionId;
	private String employeeDesignation;

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public Integer getEmployeeDesigntionId() {
		return employeeDesigntionId;
	}

	public void setEmployeeDesigntionId(Integer employeeDesigntionId) {
		this.employeeDesigntionId = employeeDesigntionId;
	}

	
}

	

