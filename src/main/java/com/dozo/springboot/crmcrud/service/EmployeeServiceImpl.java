package com.dozo.springboot.crmcrud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dozo.springboot.crmcrud.dao.EmployeeDAO;
import com.dozo.springboot.crmcrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO empDAO;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return empDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return empDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		empDAO.save(emp);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		empDAO.deleteById(id);
	}

}
