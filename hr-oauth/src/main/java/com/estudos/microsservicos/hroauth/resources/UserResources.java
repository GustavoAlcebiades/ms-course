package com.estudos.microsservicos.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.microsservicos.hroauth.entity.User;
import com.estudos.microsservicos.hroauth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {

	@Autowired
	private UserService usService;
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		try {
		User us = usService.findByEmail(email);
		return ResponseEntity.ok(us);
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
