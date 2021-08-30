package com.estudos.microsservicos.hruser.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.microsservicos.hruser.entity.User;
import com.estudos.microsservicos.hruser.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findByUser(@PathVariable Long id){
		User us = userRepository.findById(id).get();
		if(us.getId() == null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(us);
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		User obj = userRepository.findByEmail(email);
		if(email.equals(obj.getEmail())) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.notFound().build();
		
	}
}
