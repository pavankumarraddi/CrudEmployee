package com.java.employeemanagement.service;

import java.util.List;

import com.java.employeemanagement.model.EmployeeDetails;
import com.java.employeemanagement.model.dto.EmployeeDetailsReq;

public interface EmployeeDetailsService {

	EmployeeDetails save(EmployeeDetails empdetails);
	
	List<EmployeeDetails> findAll();
	
	EmployeeDetails findById(int id);
	
	public void deleteById(int id);
	
	//EmployeeDetails updateEmployeeFatherNameById(int id , String name );
	
	EmployeeDetails updateEmployeeDetails(EmployeeDetailsReq req);
	
	
	
	
}
