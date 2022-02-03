package com.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeDao;

@Service
@Qualifier("employeeProcedureServiceImpl")
public class EmployeeProcedureServiceImpl implements EmployeeService{
	
	@Autowired
	@Qualifier("employeeProcedureDaoImpl")
	EmployeeDao employeeDao;

	public List<EmployeeDto> getAllEmp() {
		List<EmployeeDto> allEmployees = new ArrayList<EmployeeDto>();
		List<Employee>  employees =employeeDao.getAllEmp();
		
		for(Employee emp :employees) {
			EmployeeDto empDto = new EmployeeDto();
			BeanUtils.copyProperties( emp, empDto );
			allEmployees.add(empDto);
		}
		
		return allEmployees;
	}

	public EmployeeDto getEmployee(int empId) {
		Employee emp =  employeeDao.getEmployee(empId);
		EmployeeDto empDto = new EmployeeDto();
		BeanUtils.copyProperties(emp, empDto);
		return empDto;
	}
	
	public String deleteEmployee(int empId) {
		String message  =  employeeDao.deleteEmployee(empId);
		return message;
	}

	public String saveEmployee(EmployeeDto emp) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(emp, employee);
		String message  =  employeeDao.saveEmplyee(employee);
		return message;
	}
	
	public EmployeeDto authenticate(String email, String password) {
		Employee employee =  employeeDao.authenticate(email, password);
		EmployeeDto empDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, empDto);
		return empDto;
	}

	public String updateEmployee(EmployeeDto emp) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(emp, employee);
		String message  =  employeeDao.updateEmplyee(employee);
		return message;
	}

}
