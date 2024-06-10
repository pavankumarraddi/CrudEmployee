package com.java.employeemanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.employeemanagement.common.ApplicationConstant;
import com.java.employeemanagement.model.Employee;
import com.java.employeemanagement.model.dto.ApiResponse;
import com.java.employeemanagement.model.dto.EmployeeReq;
import com.java.employeemanagement.service.EmployeeDetailsService;
import com.java.employeemanagement.service.EmployeeService;
import com.java.employeemanagement.util.ApiResponseHelper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired 
	EmployeeService employeeService;
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	ApiResponseHelper apiResponseHelper;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> createEmployee(@RequestBody EmployeeReq req) throws JsonProcessingException {
 
    ApiResponse apiresponse = null;

    try {
        Employee emp = employeeService.saveEmployee(req);
        if(emp != null) {
            // Success
            apiresponse = apiResponseHelper.configureResponseObj(ApplicationConstant.CREATED_RESPONSE, "Successfully Created!!", emp);
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

	@GetMapping("/get-employee/{id}")
	public ResponseEntity<ApiResponse> getEmployee(@PathVariable int id) {
	Employee employeeById = employeeService.findById(id);
	ApiResponse apiResponse = null;
	if(employeeById != null) {
		apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully retrieved data..", employeeById);
		return ResponseEntity.ok(apiResponse);
	}
	else {
		apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Data Not Found", employeeById);
		return ResponseEntity.ok(apiResponse);
	}
	
}

	@DeleteMapping("/delete-employee-by/{id}")
	public  ResponseEntity<ApiResponse>deleteEmployeeDetailsById(@PathVariable int id){
	 ApiResponse apiResponse;
     try {
         Employee employeeDetails = employeeService.findById(id);
         if (employeeDetails != null) {
             employeeService.deleteById(id);
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

	@PostMapping("/update-employee")
	public ResponseEntity<ApiResponse> updateEmployee(@RequestBody EmployeeReq req) {
	log.info("inside update employee API");
    ApiResponse apiResponse;
    try {
        Employee updatedEmployee = employeeService.updateEmployee(req);
        if (updatedEmployee != null) {
            apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully updated employee name.", updatedEmployee);
        } else {
            apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND, "Employee not found.", updatedEmployee);
        }
        return ResponseEntity.ok(apiResponse);
    } catch (Exception ex) {
        ex.printStackTrace();
        apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), null);
        return ResponseEntity.ok(apiResponse);
    
    }
}
	
	//email has to be put in url
	@GetMapping("/employee-by-email/{email}") 
	public ResponseEntity<ApiResponse> getEmployeeByEmail(@PathVariable("email") String email){
		Employee empEmail = employeeService.getEmployeeByEmail(email);
		ApiResponse apiResponse =null;
		if(empEmail != null) {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully Retrieved Data", empEmail);
			return ResponseEntity.ok(apiResponse);	
		}
		else {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND, "Not Found", empEmail);
			return ResponseEntity.ok(apiResponse);
		}
	}
	
	//email not put in url 
	@PostMapping("/getemployeebyemail") 
	public ResponseEntity<ApiResponse> getEmployeeByEmailAddress(@RequestBody EmployeeReq req){
		Employee empEmail = employeeService.getEmployeeByEmail(req.getEmployeeEmail());
		ApiResponse apiResponse =null;
		if(empEmail != null) {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully Retrieved Data", empEmail);
			return ResponseEntity.ok(apiResponse);	
		}
		else {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND, "Not Found", empEmail);
			return ResponseEntity.ok(apiResponse);
		}
	}
	
	//phone number is put in url
	@GetMapping("/employee-by-phone/{phone}") 
	public ResponseEntity<ApiResponse> getEmployeeByPhone(@PathVariable("phone") String phone){
		Employee empPhone = employeeService.getEmployeeByPhone(phone);
		ApiResponse apiResponse =null;
		if(empPhone != null) {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully Retrieved Data", empPhone);
			return ResponseEntity.ok(apiResponse);	
		}
		else {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND," Not Found", empPhone);
			return ResponseEntity.ok(apiResponse);
		}
	}
	
	@PostMapping("/employeebyphone") 
	public ResponseEntity<ApiResponse> getEmployeeByPhoneNumber(@RequestBody EmployeeReq req){
		Employee empPhone = employeeService.getEmployeeByPhone(req.getEmployeePhone());
		ApiResponse apiResponse =null;
		if(empPhone != null) {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.SUCCESS_RESPONSE, "Successfully Retrieved Data", empPhone);
			return ResponseEntity.ok(apiResponse);	
		}
		else {
			apiResponse = apiResponseHelper.configureResponseObj(ApplicationConstant.NOT_FOUND," Not Found", empPhone);
			return ResponseEntity.ok(apiResponse);
		}
	}
	
}
