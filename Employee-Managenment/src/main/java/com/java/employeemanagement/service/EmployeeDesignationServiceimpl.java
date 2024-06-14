package com.java.employeemanagement.service;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.employeemanagement.model.EmployeeDesignation;
import com.java.employeemanagement.model.dto.SaveEmployeeDesignationReq;
import com.java.employeemanagement.repository.EmployeeDesignationRepository;

@Service
public class EmployeeDesignationServiceimpl implements EmployeeDesignationService {
	
	@Autowired
	EmployeeDesignationRepository employeeDesignationRepository; 

	@Override
	public EmployeeDesignation save(EmployeeDesignation employeeDesignation) {
		return employeeDesignationRepository.save(employeeDesignation);
	}
	
	@Override
	public List<EmployeeDesignation> findAll() {
		List<EmployeeDesignation> emp = employeeDesignationRepository.findAll();
		return emp;
	}
	
	@Override
	  public EmployeeDesignation getEmployeeDesignationById(int id) {
		EmployeeDesignation emp = employeeDesignationRepository.findById(id).get();
		return emp;
    }
	
	@Override
	public EmployeeDesignation updateEmployeeDesignation(SaveEmployeeDesignationReq req) {
		try {
			EmployeeDesignation updateEmpDesignation = employeeDesignationRepository.findById(req.getEmployeeDesigntionId()).orElse(null);
			if (updateEmpDesignation != null) {
				updateEmpDesignation.setEmployeeDesignation(req.getEmployeeDesignation());
				return employeeDesignationRepository.save(updateEmpDesignation);
			}
			else {
				return updateEmpDesignation;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
}
