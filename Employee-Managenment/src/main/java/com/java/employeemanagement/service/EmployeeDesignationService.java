package com.java.employeemanagement.service;

import java.util.List;
import com.java.employeemanagement.model.EmployeeDesignation;
import com.java.employeemanagement.model.dto.SaveEmployeeDesignationReq;


public interface EmployeeDesignationService {

	EmployeeDesignation save(EmployeeDesignation employeeDesignation);
	
	List<EmployeeDesignation> findAll();
	
	EmployeeDesignation getEmployeeDesignationById(int id);

	EmployeeDesignation updateEmployeeDesignation(SaveEmployeeDesignationReq req);
}
