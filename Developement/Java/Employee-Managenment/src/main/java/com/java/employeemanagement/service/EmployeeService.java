package com.java.employeemanagement.service;


import com.java.employeemanagement.model.dto.EmployeeReq;
import com.java.employeemanagement.model.Employee;


public interface EmployeeService {

	Employee saveEmployee(EmployeeReq employee);
	
    Employee findById(int id);
    
    void deleteById(int id);

	Employee updateEmployee(EmployeeReq req);
	
	//Employee updatedEmployee(EmployeeReq req );
	
	Employee getEmployeeByPhone(String phone);
	
	Employee getEmployeeByEmail(String email);

}