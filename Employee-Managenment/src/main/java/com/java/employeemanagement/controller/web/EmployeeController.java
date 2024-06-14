package com.java.employeemanagement.controller.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.employeemanagement.model.Employee;
import com.java.employeemanagement.model.EmployeeDesignation;
import com.java.employeemanagement.model.EmployeeDetails;
import com.java.employeemanagement.model.dto.EmployeeReq;
import com.java.employeemanagement.service.EmployeeDesignationService;
import com.java.employeemanagement.service.EmployeeDetailsService;
import com.java.employeemanagement.service.EmployeeService;
import com.java.employeemanagement.util.ApiResponseHelper;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/emp")
@Controller
@Slf4j
public class EmployeeController {

Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired 
	EmployeeService employeeService;
	
	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@Autowired
	EmployeeDesignationService employeeDesignationService;
	
	@Autowired
	ApiResponseHelper apiResponseHelper;
	
	
	@GetMapping("/dashboard")
	public String Dashboard(Model model) {
		List<Employee> employee = employeeService.findAll();
		model.addAttribute("employee", employee);
		return "index.html";
	}
	
	@GetMapping("/detailList")
	public String getDetailList(@RequestParam("id") int id, Model model) {
		EmployeeDetails employeeDetail = employeeDetailsService.findById(id);
		System.out.println("empDetail => " + employeeDetail.toString());
		model.addAttribute("employeeDetail", employeeDetail);
		return "detailList.html";
	}
	
	@GetMapping("/addEmployee")
	public String getEmployeeDesignationList(Model model) {
		List<EmployeeDesignation> designationList = employeeDesignationService.findAll(); 
		model.addAttribute("employeeDesignation" ,designationList);
		return "employees.html";
	}
	
	@PostMapping("/saveEmployee")
    public String createEmployee(Employee emp, Model model) throws JsonProcessingException {
		System.out.println(" form data==>"+ emp.getEmployeeDesignation());
        Employee savedEmp = employeeService.saveEmployee(emp);
//        model.addAttribute("employee", savedEmp);
        return "redirect:/emp/addEmployee";
    }
	
}
