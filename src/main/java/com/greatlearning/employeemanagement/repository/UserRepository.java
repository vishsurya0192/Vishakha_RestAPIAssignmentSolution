package com.greatlearning.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.employeemanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User getUserByUsername(String username);
	

}
