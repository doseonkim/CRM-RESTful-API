package com.dozo.springboot.crmcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dozo.springboot.crmcrud.dao.EmployeeRepo;
import com.dozo.springboot.crmcrud.entity.Employee;

@Service
public class EmployeeServiceRepoImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = empRepo.findById(id);
		Employee emp = null;
		if (result.isPresent())
			emp = result.get();
		else 
			throw new RuntimeException("Did not find employee id - " + id);
		return emp;
	}

	@Override
	public void save(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public void deleteById(int id) {
		empRepo.deleteById(id);
	}

}
