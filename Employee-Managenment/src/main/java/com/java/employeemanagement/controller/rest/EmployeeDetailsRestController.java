package com.java.employeemanagement.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.employeemanagement.common.ApplicationConstant;
import com.java.employeemanagement.model.Employee;
import com.java.employeemanagement.model.EmployeeDetails;
import com.java.employeemanagement.model.dto.ApiResponse;
import com.java.employeemanagement.model.dto.EmployeeDetailsReq;
import com.java.employeemanagement.model.dto.EmployeeReq;
import com.java.employeemanagement.service.EmployeeDetailsService;
import com.java.employeemanagement.util.ApiResponseHelper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee-details")
@Slf4j
public class EmployeeDetailsRestController {
 
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	ApiResponseHelper apiResponseHelper;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveEmployeeDetails(@RequestBody EmployeeDetailsReq req )throws JsonProcessingException {
		EmployeeDetails empdetails = new EmployeeDetails();
		empdetails.setActive(true);
		empdetails.setFatherName(req.getFatherName());
		empdetails.setMotherName(req.getMotherName());
		empdetails.setAddress(req.getAddress());
		empdetails.setCity(req.getCity());
		empdetails.setCountry(req.getCountry());
		empdetails.setPincode(req.getPincode());
		ApiResponse apiresponse = null;
		   try {
		        EmployeeDetails empp = employeeDetailsService.save(empdetails);
		        if(empp != null) {
		            // Success
		            apiresponse = apiResponseHelper.configureResponseObj(ApplicationConstant.CREATED_RESPONSE, "Successfully Created!!", empp);
		            return ResponseEntity.ok(apiresponse);
		        } else {
		            // Failure
		            apiresponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, "Error occurred while saving data.", null);
		            return ResponseEntity.ok(apiresponse);
		        }
		    } catch(Exception ex) {
		        ex.printStackTrace();
		        apiresponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), null);
		        return ResponseEntity.ok(apiresponse);
		    }
	}
	@GetMapping("/employee-details-by/{id}")
	public ResponseEntity<ApiResponse> getEmployeeDetailsById(@PathVariable int id) {
		EmployeeDetails emp = employeeDetailsService.findById(id);
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
	
	@DeleteMapping("/delete-employee-details-by/{id}")
	public  ResponseEntity<ApiResponse>deleteEmployeeDetailsById(@PathVariable int id){
		 ApiResponse apiResponse;
	     try {
	         EmployeeDetails employeeDetails = employeeDetailsService.findById(id);
	         if (employeeDetails != null) {
	        	 employeeDetailsService.deleteById(id);
	             apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully deleted.", null);
	         } else {
	             apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND, "Employee not found.", null);
	         }
	         return ResponseEntity.ok(apiResponse);
	     } catch (Exception ex) {
	         ex.printStackTrace();
	         apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), null);
	         return ResponseEntity.ok(apiResponse);
	     }
	 } 
	
	//@PutMapping("/update-fathername/{id}")
	//public ResponseEntity<ApiResponse> updateEmployeeFatherNameById(@PathVariable int id, @RequestParam String name) {
	//    ApiResponse apiResponse;
	//    try {
	//        EmployeeDetails updatedEmployee = employeeDetailsService.updateEmployeeFatherNameById(id, name);
	//        if (updatedEmployee != null) {
	//            apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully updated employee name.", updatedEmployee);
	//        } else {
	//            apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND, "Employee not found.", null);
	//        }
	//        return ResponseEntity.ok(apiResponse);
	//    } catch (Exception ex) {
	//        ex.printStackTrace();
	//        apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), null);
	//        return ResponseEntity.ok(apiResponse);
	//    
	//    }
	//}
	@PostMapping("/update-employeeDetails")
	public ResponseEntity<ApiResponse> updateEmployeeDeails(@RequestBody EmployeeDetailsReq req) {
	    ApiResponse apiResponse;
	    try {
	        EmployeeDetails updatedEmployeeDetails = employeeDetailsService.updateEmployeeDetails(req);
	        if (updatedEmployeeDetails != null) {
	            apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully updated employee name.", updatedEmployeeDetails);
	        } else {
	            apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND, "Employee not found.", null);
	        }
	        return ResponseEntity.ok(apiResponse);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), null);
	        return ResponseEntity.ok(apiResponse);
	    
	    }
	}
}