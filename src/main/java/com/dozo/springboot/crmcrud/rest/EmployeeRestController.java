package com.dozo.springboot.crmcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dozo.springboot.crmcrud.entity.Employee;
import com.dozo.springboot.crmcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	@Qualifier("employeeServiceRepoImpl")
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findEmployee(@PathVariable int id) {
		Employee emp = service.findById(id);
		if (emp == null) 
			throw new RuntimeException("Employee not found - " + id);
		
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		service.save(emp);
		return emp;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		service.save(emp);
		return emp;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee emp = service.findById(id);
		if (emp == null)
			throw new RuntimeException("Employee not found - " + id);
		service.deleteById(id);
		return "Employee successfully deleted.";
	}
	
}
