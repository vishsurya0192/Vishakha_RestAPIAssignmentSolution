package com.greatlearning.employeemanagement.service;

import java.util.List;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;

public interface RolesService {
	Role addRole(String name);
	
	User addUser(String username, String password, String roleName);
	List<Role> listAllRoles();


}
