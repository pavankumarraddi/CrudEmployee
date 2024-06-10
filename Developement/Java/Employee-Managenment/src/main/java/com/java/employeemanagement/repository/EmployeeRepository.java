package com.java.employeemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.employeemanagement.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	
	Optional<Employee> findByEmployeePhone(String phone);
    Optional<Employee> findByEmployeeEmail(String email);
	

}
