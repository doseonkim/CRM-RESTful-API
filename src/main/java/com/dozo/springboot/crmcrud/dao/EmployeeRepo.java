package com.dozo.springboot.crmcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dozo.springboot.crmcrud.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
