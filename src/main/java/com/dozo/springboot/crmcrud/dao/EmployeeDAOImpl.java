package com.dozo.springboot.crmcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dozo.springboot.crmcrud.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entity;
	
	@Override
	public List<Employee> findAll() {
		Session session = entity.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findById(int id) {
		Session session = entity.unwrap(Session.class);
		return session.find(Employee.class, id);
	}

	@Override
	public void save(Employee emp) {
		Session session = entity.unwrap(Session.class);
		session.saveOrUpdate(emp);
	}

	@Override
	public void deleteById(int id) {
		Session session = entity.unwrap(Session.class);
		Query q = session.createQuery("delete from Employee where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
	}
}
