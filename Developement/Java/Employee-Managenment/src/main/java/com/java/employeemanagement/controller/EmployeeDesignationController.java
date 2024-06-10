package com.java.employeemanagement.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.employeemanagement.common.ApplicationConstant;
import com.java.employeemanagement.model.Employee;
import com.java.employeemanagement.model.EmployeeDesignation;
import com.java.employeemanagement.model.dto.ApiResponse;
import com.java.employeemanagement.model.dto.EmployeeReq;
import com.java.employeemanagement.model.dto.SaveEmployeeDesignationReq;
import com.java.employeemanagement.service.EmployeeDesignationService;
import com.java.employeemanagement.util.ApiResponseHelper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee-designation")
@Slf4j
public class EmployeeDesignationController {
	
	@Autowired
	EmployeeDesignationService employeeDesignationService;
	
	@Autowired
	ApiResponseHelper apiResponseHelper;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveEmployeeDesignation(@RequestBody SaveEmployeeDesignationReq req) throws JsonProcessingException{
		EmployeeDesignation desig = new EmployeeDesignation();
		desig.setActive(true);
		desig.setEmployeeDesignation(req.getEmployeeDesignation());
		ApiResponse apiresponse = null;
		try {
			EmployeeDesignation empp = employeeDesignationService.save(desig);
			if(empp != null) {
//			Success
				apiresponse = apiResponseHelper.configureResponseObj(ApplicationConstant.CREATED_RESPONSE, "Successfully Cretaed!!", empp);
				return ResponseEntity.ok(apiresponse);
			}else {
//			failure
				apiresponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, "Error occured while saving data..", null);
				return ResponseEntity.ok(apiresponse);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			apiresponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), null);
			return ResponseEntity.ok(apiresponse);
		}
		
	}
  
	
	@GetMapping("/employee-designation-list")
	public ResponseEntity<ApiResponse> getallEmployeeDesignation()
	{
		List<EmployeeDesignation> designationList = employeeDesignationService.findAll(); 
		ApiResponse apiResponse = null;
		if(!CollectionUtils.isEmpty(designationList)) {
			// not empty
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully retrieved data..", designationList);
			return ResponseEntity.ok(apiResponse);
		
		}else {
			// empty ==> No data found
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "No data found..", designationList);
			return ResponseEntity.ok(apiResponse);
		}
	}
	
	@GetMapping("/employee-designation-by/{id}")
    public ResponseEntity<ApiResponse> getEmployeeDesignationById(@PathVariable int id) {
		EmployeeDesignation emp = employeeDesignationService.getEmployeeDesignationById(id);
		ApiResponse apiResponse = null;
		if(emp != null) {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully retrieved data..", emp);
			return ResponseEntity.ok(apiResponse);
		}
		else {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Data Not Found", emp);
			return ResponseEntity.ok(apiResponse);
		}
		
    }
	
	@PostMapping("/update-employeeDesignation")
	public ResponseEntity<ApiResponse> updateEmployeeDesignation(@RequestBody SaveEmployeeDesignationReq req){
		   ApiResponse apiResponse;
		    try {
		    	EmployeeDesignation updateEmpDesignation = employeeDesignationService.updateEmployeeDesignation(req);
		        if (updateEmpDesignation != null) {
		            apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully updated employee name.", updateEmpDesignation);
		        } else {
		            apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND, "Employee not found.", updateEmpDesignation);
		        }
		        return ResponseEntity.ok(apiResponse);
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), null);
		        return ResponseEntity.ok(apiResponse);
		    
		    }
	}
}
