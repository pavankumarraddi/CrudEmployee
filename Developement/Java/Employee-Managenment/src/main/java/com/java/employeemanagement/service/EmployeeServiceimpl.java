package com.java.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java.employeemanagement.model.EmployeeDesignation;
import com.java.employeemanagement.model.EmployeeDetails;
import com.java.employeemanagement.model.dto.EmployeeReq;
import com.java.employeemanagement.model.Employee;
import com.java.employeemanagement.repository.EmployeeDesignationRepository;
import com.java.employeemanagement.repository.EmployeeDetailsRepository;
import com.java.employeemanagement.repository.EmployeeRepository;
import com.java.employeemanagement.util.ApiResponseHelper;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeDesignationRepository employeeDesignationRepository;
	
	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	
	@Autowired
	ApiResponseHelper apiResponseHelper;
	
	@Override
	public Employee saveEmployee(EmployeeReq req) {
	    Employee emp = new Employee();
	    EmployeeDesignation empDesignation = employeeDesignationRepository.findById(req.getEmployeeDesignationId()).get();
	    EmployeeDetails  empDetails = employeeDetailsRepository.findById(req.getEmployeeDetailsId()).get();
	    emp.setActive(true);
	    emp.setEmployeeFirstName(req.getEmployeeFirstName());
	    emp.setEmployeeLastName(req.getEmployeeLastName());
	    emp.setEmployeeEmail(req.getEmployeeEmail());
	    emp.setEmployeePhone(req.getEmployeePhone());
	    emp.setEmployeeDesignation(empDesignation);
	    emp.setEmployeeDetails(empDetails);
	    
	    
		return employeeRepository.save(emp);
	}
	
	@Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }
	
	@Override
	public Employee getEmployeeByPhone(String phone){
		return employeeRepository.findByEmployeePhone(phone).orElse(null);
	}
	
	@Override
	public Employee getEmployeeByEmail(String email){
		return employeeRepository.findByEmployeeEmail(email).orElse(null);
	}
	
	@Override
	public void deleteById(int id) {
	  employeeRepository.deleteById(id);
	}
	
//	@Override
//	public Employee updatedEmployee(EmployeeReq req) {
//		Employee updateEmp = new Employee();
//		EmployeeDesignation employeeDesignation = employeeDesignationRepository.findById(req.getEmployeeDesignationId()).get();
//		EmployeeDetails employeeDetails = employeeDetailsRepository.findById(req.getEmployeeDetailsId()).get();
//		//Employee updatedemployee = employeeRepository.findById(req.getId()).orElse(null);
//        //if (updateemp != null) {
//		updateEmp.setActive(true);
//		updateEmp.setEmployeeDesignation(employeeDesignation);
//		updateEmp.setEmployeeDetails(employeeDetails);
//		updateEmp.setEmployeeFirstName(req.getEmployeeFirstName());
//		updateEmp.setEmployeeLastName(req.getEmployeeLastName());
//		updateEmp.setEmployeeEmail(req.getEmployeeEmail());
//		updateEmp.setEmployeePhone(req.getEmployeeEmail());
//		    return employeeRepository.save(updateEmp);
//	       //}
//       // return null;
//	    }
	

	@Override
	public Employee updateEmployee(EmployeeReq req){
		try {
				Employee employee = employeeRepository.findById(req.getId()).orElse(null);
				if (employee != null) {
					employee.setEmployeeFirstName(req.getEmployeeFirstName());
					employee.setEmployeeLastName(req.getEmployeeLastName());
					employee.setEmployeeEmail(req.getEmployeeEmail());
					employee.setEmployeePhone(req.getEmployeePhone());
					return employeeRepository.save(employee);
				}
				else {
					 return employee;
				}
		   }
		   catch (Exception ex) {
			ex.printStackTrace();
			return null;
		   }
	}
}





