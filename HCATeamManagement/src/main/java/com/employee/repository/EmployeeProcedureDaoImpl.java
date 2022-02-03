package com.employee.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
@Qualifier("employeeProcedureDaoImpl")
public class EmployeeProcedureDaoImpl implements EmployeeDao{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	private SimpleJdbcCall simpleJdbcCall;
	 
	public EmployeeProcedureDaoImpl() {
		
	}
	
	@PostConstruct
	public void init() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String saveEmplyee(Employee emp) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("CreateEmployee").returningResultSet("employees", new BeanPropertyRowMapper(Employee.class));
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("p_name", emp.getName())
				.addValue("p_age", emp.getAge()).addValue("p_department", emp.getDepartment())
				.addValue("p_mobile", emp.getMobile()).addValue("p_email", emp.getEmail()).addValue("p_address", emp.getAddress())
				.addValue("p_salary", emp.getSalary()).addValue("p_password", emp.getPassword());
		Map<String, Object> out = simpleJdbcCall.execute(params);
		int rowCount = (Integer) out.get("#update-count-1");
		return 	rowCount>0 ? "Save sucessfull" : "Save unscessfull";
	}

	public String deleteEmployee(int empId) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("DeleteEmployeeById").returningResultSet("employees", new BeanPropertyRowMapper(Employee.class));
		SqlParameterSource params = new MapSqlParameterSource().addValue("id_in", empId);
		Map<String, Object> out = simpleJdbcCall.execute(params);
		int rowCount = (Integer) out.get("#update-count-1");
		return 	rowCount>0 ? "Delete sucessfull" : "Delete unscessfull";
	}

	public String updateEmplyee(Employee emp) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("UpdateEmployee").returningResultSet("employees", new BeanPropertyRowMapper(Employee.class));
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("p_id", emp.getId()).addValue("p_name", emp.getName())
				.addValue("p_age", emp.getAge()).addValue("p_department", emp.getDepartment())
				.addValue("p_mobile", emp.getMobile()).addValue("p_email", emp.getEmail()).addValue("p_address", emp.getAddress())
				.addValue("p_salary", emp.getSalary()).addValue("p_password", emp.getPassword());
		Map<String, Object> out = simpleJdbcCall.execute(params);
		int rowCount = (Integer) out.get("#update-count-1");
		return 	rowCount>0 ? "Update sucessfull" : "Update unscessfull";
	}

	public Employee getEmployee(int empId) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("FindEmployeeById").returningResultSet("employees", new BeanPropertyRowMapper(Employee.class));
		SqlParameterSource params = new MapSqlParameterSource().addValue("id_in", empId);
		Map<String, Object> out = simpleJdbcCall.execute(params);
		Employee emp = ((List<Employee>) out.get("employees")).get(0);
		return emp;
	}

	public List<Employee> getAllEmp() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("GetAllEmployees").returningResultSet("employees", new BeanPropertyRowMapper(Employee.class));
		 Map<String, Object> out = simpleJdbcCall.execute();
		 List<Employee> employees = (List<Employee>) out.get("employees");
		System.out.println("employees----"+employees);
		return employees; 
	}

	public Employee authenticate(String email, String password) {
		Employee employee = jdbcTemplate.queryForObject("select * from employee where email =? and password=?", new Object[] {email,password},new BeanPropertyRowMapper(Employee.class));
		return employee;
	}
}
