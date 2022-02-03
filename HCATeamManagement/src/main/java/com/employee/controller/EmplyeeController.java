package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@Controller
public class EmplyeeController {
	
	@Autowired
	@Qualifier("employeeServiceImpl")
	EmployeeService employeeService;
	
	@GetMapping("/findEmployee")
	public String getAllEMployee(Model model) {
		List<EmployeeDto> employees = employeeService.getAllEmp();
		model.addAttribute("allEmployee", employees);
		return "showEmployees";		
	}
	

	@GetMapping("/getEmployee")
	public String getEMployee(@RequestParam int employeeId, Model model) {
		EmployeeDto dto = employeeService.getEmployee(employeeId);
		model.addAttribute("employee",dto); //add data in request
		return "employeeDetail"; //call jsp/view
	}
	
	@GetMapping("/registration")
	public String employeeRegistration( Model model) {
		return "registration"; //call jsp/view
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam int employeeId, Model model) {
		String message = employeeService.deleteEmployee(employeeId);
		model.addAttribute("message", message);
		System.out.println("Delete process");
		return "redirect:findEmployee";
	}
	
	@PostMapping("/registerEmployee")
	public String insertEmployee(@ModelAttribute EmployeeDto emp, Model  model) {
		String message= employeeService.saveEmployee(emp);
		model.addAttribute("message", message);
		return "registration";
	}
	
	@GetMapping("/login")
	public String employeeLogin() {
		return "login"; //call jsp/view
	}
	@GetMapping("/home")
	public String home() {
		return "home"; //call jsp/view
	}
	
	@PostMapping("/authentication")
	public String authentication(@RequestParam String email,@RequestParam String password, Model  model, HttpSession session) {
		EmployeeDto empDto = employeeService.authenticate(email , password );
		if(empDto !=null) {
			session.setAttribute("name", empDto.getName());
			session.setAttribute("email", empDto.getEmail());
			return "redirect:findEmployee";
		}else{
			model.addAttribute("message", "user idpassword not correct");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout( Model model, HttpSession session) {
		if(session !=null) {
			session.invalidate();
		}
		return "login";
	}
	@GetMapping(value="/editEmployee")    
	    public String updateEmployee(@RequestParam int employeeId, Model model) {    
			EmployeeDto dto = employeeService.getEmployee(employeeId);
			model.addAttribute("employee",dto);
	        return "editEmployee";    
	 }
	@PostMapping("/editEmployee")
	public String editEmployee(@ModelAttribute EmployeeDto emp, Model  model) {
		String message= employeeService.updateEmployee(emp);
		model.addAttribute("message", message);
		return "editEmployee";

	}

}
