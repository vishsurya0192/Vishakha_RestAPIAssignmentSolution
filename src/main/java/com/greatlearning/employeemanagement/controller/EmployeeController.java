package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("") // not required
	public String demo() {
		return "Welcome to Employee Management Application";
	}

	@GetMapping("/list")
	public List<Employee> list() {

		return employeeService.findAll();
	}

	@PostMapping("/add")
	public Employee add(Employee employee) {
		employeeService.save(employee);
		return employeeService.findById(employee.getId());
	}

	@PostMapping("/update")
	public Employee update(Employee employee) {
		employeeService.save(employee);
		return employeeService.findById(employee.getId());

	}

	@DeleteMapping("/delete")
	public String delete(int id) {

		employeeService.deleteById(id);
		return "Deleted employee with id";

	}

	@GetMapping("/sortedlist")
	public List<Employee> getSortedList(Direction direction) {

		return employeeService.findAllEmployeeSorted(direction);
	}

	@GetMapping("/get")
	public Employee getById(int id) {
		return employeeService.findById(id);

	}

	@GetMapping("/search")
	public List<Employee> search(String firstName) {
		return employeeService.search(firstName);
	}

}
