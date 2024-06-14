package com.java.employeemanagement.util;

import org.springframework.stereotype.Component;

import com.java.employeemanagement.model.dto.ApiResponse;

@Component
public class ApiResponseHelper {

	public ApiResponse configureResponseObj(String status, String message, Object emp) {
		ApiResponse apiresponse = new ApiResponse();
		apiresponse.setStatus(status);
		apiresponse.setMessage(message);
		apiresponse.setData(emp);
		return apiresponse;
	}
}
