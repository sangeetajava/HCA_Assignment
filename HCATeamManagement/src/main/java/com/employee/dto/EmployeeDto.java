package com.employee.dto;

public class EmployeeDto {

	private int id ;
	private String name;
	private int age;
	private int salary;
	private String department;
	private String address;
	private String mobile;
	private String email;
	private String password;
	
	
	
	public EmployeeDto(int id, String name, int age, int salary, String department, String address, String mobile,
			String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.department = department;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeDto() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", department="
				+ department + ", address=" + address + ", mobile=" + mobile + "]";
	}
	
	
	
}
