package com.greatlearning.employeemanagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.employeemanagement.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int id);	
	void deleteById(int id);
	void save(Employee employee);
	List<Employee> search(String firstName);
	List<Employee> findAllEmployeeSorted(Direction direction);
	

}
