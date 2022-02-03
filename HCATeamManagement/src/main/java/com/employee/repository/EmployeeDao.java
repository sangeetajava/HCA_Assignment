package com.employee.repository;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeDao {

	public String saveEmplyee(Employee emp);
	public String deleteEmployee(int empId);
	public String updateEmplyee(Employee emp);
	public Employee getEmployee(int empId) ;
	public  List<Employee> getAllEmp() ;
	public Employee authenticate(String email , String password) ;
}
