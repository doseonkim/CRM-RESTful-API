package com.dozo.springboot.crmcrud.service;

import java.util.List;

import com.dozo.springboot.crmcrud.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void deleteById(int id);
}
