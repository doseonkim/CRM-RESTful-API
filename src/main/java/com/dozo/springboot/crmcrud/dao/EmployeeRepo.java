package com.dozo.springboot.crmcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dozo.springboot.crmcrud.entity.Employee;

@RepositoryRestResource(path="members")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
}
