package com.employee.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
@Qualifier("employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao{
	
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	public EmployeeDaoImpl() {
		
	}
	
	@PostConstruct
	public void init() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String saveEmplyee(Employee emp) {
		Object[] args = {emp.getName(),emp.getAge(),emp.getSalary(),emp.getDepartment(),emp.getDepartment(),emp.getMobile(),emp.getEmail(),emp.getPassword()};
		int rowCount = jdbcTemplate.update("insert into employee(name,age,salary,department,address, mobile, email , password) values(?,?,?,?,?,?,?,?)", args);
		return 	rowCount>0 ? "Employee has been registered sucessfull" : "Insert unsucessfull";
	}


	public String updateEmplyee(Employee emp) {
		Object[] args = {emp.getName(),emp.getAge(),emp.getSalary(),emp.getDepartment(),emp.getDepartment(),emp.getMobile(),emp.getEmail(),emp.getPassword(),emp.getId()};
		int rowCount = jdbcTemplate.update("update employee set name=?, age=?, salary=?,department=?, address=?, mobile=?, email=?, password=? where id=?", args);
		
		return 	rowCount>0 ? "Employee has been updated sucessfully" : "Employee update was unsucessfull";
	}

	public String deleteEmployee(int empId) {
		int rowCount = jdbcTemplate.update("delete from employee where id=?", empId);
		return 	rowCount>0 ? "Delete sucessfull" : "Delete unscessfull";
	}

	public Employee getEmployee(int empId) {
		Employee employee = jdbcTemplate.queryForObject("select * from employee where id=?",new Object[] {empId} ,new BeanPropertyRowMapper(Employee.class));
		return employee;
	}

	public List<Employee> getAllEmp() {
		List<Employee> employees = jdbcTemplate.query("select * from employee", new BeanPropertyRowMapper(Employee.class));
		return employees; 
	}

	public Employee authenticate(String email, String password) {
		Employee employee = jdbcTemplate.queryForObject("select * from employee where email =? and password=?", new Object[] {email,password},new BeanPropertyRowMapper(Employee.class));
		return employee;
	}

	
}
