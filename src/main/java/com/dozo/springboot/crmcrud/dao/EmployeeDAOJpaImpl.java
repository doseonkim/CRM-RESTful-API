package com.dozo.springboot.crmcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dozo.springboot.crmcrud.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entity;
	
	@Override
	public List<Employee> findAll() {
		Query q = entity.createQuery("from Employee");
		List<Employee> employees = q.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		return entity.find(Employee.class, id);
	}

	@Override
	public void save(Employee emp) {
		Employee dbEmp = entity.merge(emp); //0 is insert and update otherwise.
		emp.setId(dbEmp.getId());
	}

	@Override
	public void deleteById(int id) {
		Query q = entity.createQuery("delete from Employee where id=:employeeId");
		q.setParameter("employeeId", id);
		q.executeUpdate();
	}

}
