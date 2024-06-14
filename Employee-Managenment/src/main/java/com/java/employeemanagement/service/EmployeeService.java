package com.java.employeemanagement.service;


import com.java.employeemanagement.model.dto.EmployeeReq;

import java.util.List;

import com.java.employeemanagement.model.Employee;
import com.java.employeemanagement.model.EmployeeDetails;


public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> findAll();
	
    Employee findById(int id);
    
    void deleteById(int id);

	Employee updateEmployee(EmployeeReq req);
	
	//Employee updatedEmployee(EmployeeReq req );
	
	Employee getEmployeeByPhone(String phone);
	
	Employee getEmployeeByEmail(String email);
}