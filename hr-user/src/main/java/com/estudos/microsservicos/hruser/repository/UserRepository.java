package com.estudos.microsservicos.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos.microsservicos.hruser.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
