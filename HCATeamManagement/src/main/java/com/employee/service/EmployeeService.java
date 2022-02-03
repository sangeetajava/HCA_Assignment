package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;


public interface EmployeeService {
	
	public  List<EmployeeDto> getAllEmp() ;
	public EmployeeDto getEmployee(int empId) ;
	public String deleteEmployee(int empId) ;
	public String saveEmployee(EmployeeDto emp) ;
	public EmployeeDto authenticate(String email , String password) ;
	public String updateEmployee(EmployeeDto emp) ;

}
