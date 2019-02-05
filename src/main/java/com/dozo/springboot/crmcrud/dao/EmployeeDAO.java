package com.dozo.springboot.crmcrud.dao;

import java.util.List;

import com.dozo.springboot.crmcrud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void deleteById(int id);
}
