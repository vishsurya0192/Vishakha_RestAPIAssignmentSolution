package com.greatlearning.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;
import com.greatlearning.employeemanagement.service.RolesService;

@RestController
@RequestMapping("/signup")
public class UserRolesController {
	
	@Autowired
	private RolesService rolesService;
	
	@GetMapping("/listRoles")
	public List<Role> listRoles(){
		return rolesService.listAllRoles();
	}
	
	@PostMapping("/newRole")
	public Role addRole(String name) {
		return rolesService.addRole(name);
	}
	
	@PostMapping("/newUser")
	public User addUser(String username, String password, String name) {
		return rolesService.addUser(username, password, name);
	}
	
	

}
