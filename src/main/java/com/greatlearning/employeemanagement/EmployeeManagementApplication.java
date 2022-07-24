package com.greatlearning.employeemanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;
import com.greatlearning.employeemanagement.repository.UserRepository;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setId(1);
		user.setUsername("user1");
		user.setPassword(new BCryptPasswordEncoder().encode("123"));
		List<Role> roles = new ArrayList<>();
		roles.add(new Role(1, "ADMIN"));
		user.setListOfRoles(roles);
		userRepository.save(user);
		
		
	}

}
