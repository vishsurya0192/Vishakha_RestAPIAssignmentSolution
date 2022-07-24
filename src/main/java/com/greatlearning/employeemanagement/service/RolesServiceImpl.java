package com.greatlearning.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;
import com.greatlearning.employeemanagement.repository.RoleRepository;
import com.greatlearning.employeemanagement.repository.UserRepository;

@Service
public class RolesServiceImpl implements RolesService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;

	@Override
	public Role addRole(String name) {
		// TODO Auto-generated method stub
		
		Role role = roleRepository.findRoleByName(name);
		if(role != null)
		return role;
		
		role = new Role();
		role.setName(name);
		return roleRepository.save(role);
	}

	@Override
	public User addUser(String username, String password, String roleName) {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		
		List<Role> roles = new ArrayList<Role>();
		Role role = roleRepository.findRoleByName(roleName);
		
		if(role == null)
			role = addRole(roleName);
		roles.add(role);
		user.setListOfRoles(roles);
		return userRepository.save(user);
	}

	@Override
	public List<Role> listAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
