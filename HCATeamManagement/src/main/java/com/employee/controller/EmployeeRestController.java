package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.ApplicationResponseDto;
import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	@Qualifier("employeeProcedureServiceImpl")
	EmployeeService employeeService;
	
	@GetMapping(path="/getAllEmployees", produces = "application/json")
	public List<EmployeeDto> getAllEMployee() {
		List<EmployeeDto> employees = employeeService.getAllEmp();
		return employees;		
	}
	
	@GetMapping("/findEmployee/byId/{employeeId}")
	public 	EmployeeDto getEMployee(@PathVariable int employeeId) {
		EmployeeDto dto = employeeService.getEmployee(employeeId);
		return dto;
	}
	
	@GetMapping("/deleteEmployee/byId/{employeeId}")
	public ApplicationResponseDto deleteEmployee(@PathVariable int employeeId) {
		String message = employeeService.deleteEmployee(employeeId);
		ApplicationResponseDto response = new ApplicationResponseDto();
		response.setCode(200);
		response.setMessage(message);
		response.setStatus("Success");
		return response;
	}
	
	@PostMapping("/createEmployee")
	public ApplicationResponseDto insertEmployee(@RequestBody EmployeeDto emp) {
		String message= employeeService.saveEmployee(emp);
		ApplicationResponseDto response = new ApplicationResponseDto();
		response.setCode(200);
		response.setMessage(message);
		response.setStatus("Success");
		return response;
	}
	
	@PostMapping("/changeEmployee")
	public ApplicationResponseDto editEmployee(@RequestBody EmployeeDto emp) {
		String message= employeeService.updateEmployee(emp);
		ApplicationResponseDto response = new ApplicationResponseDto();
		response.setCode(200);
		response.setMessage(message);
		response.setStatus("Success");
		return response;
	}
	
	@PostMapping("/authenticate")
	public String authentication(@RequestBody EmployeeDto emp) {
		EmployeeDto empDto = employeeService.authenticate(emp.getEmail() , emp.getPassword() );
		if(empDto !=null) {
			return "employee login sucessfull";
		}else{
			return "Please check either username or password is not correct";
		}
	}
	
	@GetMapping("/findEmployee/byName/{name}")
	public 	EmployeeDto getEMployee(@PathVariable String name) {
		EmployeeDto dto = new EmployeeDto();
		return dto;
	}
	
}
