package com.java.employeemanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.java.employeemanagement.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {
	
}
