package com.estudos.microsservicos.hroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.microsservicos.hroauth.entity.User;
import com.estudos.microsservicos.hroauth.feignClients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User us = userFeignClient.findByEmail(email).getBody();
		if(us == null) {
			throw new IllegalArgumentException("Email not found !");
		}
		return us;
	}
}
