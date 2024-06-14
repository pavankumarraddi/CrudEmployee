package com.java.employeemanagement.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.employeemanagement.model.Employee;
import com.java.employeemanagement.model.EmployeeDesignation;
import com.java.employeemanagement.model.EmployeeDetails;
import com.java.employeemanagement.model.dto.EmployeeDetailsReq;
import com.java.employeemanagement.model.dto.EmployeeReq;
import com.java.employeemanagement.repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsServiceimpl implements EmployeeDetailsService {
	
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
	
	@Override
	public EmployeeDetails save(EmployeeDetails empdetails) {
	 return employeeDetailsRepository.save(empdetails);
	}

	@Override
	public List<EmployeeDetails> findAll() {
		return employeeDetailsRepository.findAll();
	}
	
	@Override
    public EmployeeDetails findById(int id) {
        return employeeDetailsRepository.findById(id).orElse(null); // Handle the case when the employee is not found
    }
	
	@Override
	public void deleteById(int id) {
	  employeeDetailsRepository.deleteById(id);
	}
	
//	@Override
//	public EmployeeDetails updateEmployeeFatherNameById(int id , String name ) {
//		EmployeeDetails employeeDetails = employeeDetailsRepository.findById(id).orElse(null);
//        if (employeeDetails != null) {
//            employeeDetails.setFatherName(name);
//		return employeeDetailsRepository.save(employeeDetails);
//	}
//        return null;
//	    }
	
	@Override
	public EmployeeDetails updateEmployeeDetails(EmployeeDetailsReq req) {
		EmployeeDetails updateempdetails = new EmployeeDetails();
		updateempdetails.setActive(true);
		updateempdetails.setId(req.getId());
		updateempdetails.setAddress(req.getAddress());
		updateempdetails.setCity(req.getCity());
		updateempdetails.setCountry(req.getCountry());
		updateempdetails.setFatherName(req.getFatherName());
		updateempdetails.setMotherName(req.getMotherName());
		updateempdetails.setPincode(req.getPincode());
		    return employeeDetailsRepository.save(updateempdetails);
	}
}
