package com.carefirst.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carefirst.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
		
}
