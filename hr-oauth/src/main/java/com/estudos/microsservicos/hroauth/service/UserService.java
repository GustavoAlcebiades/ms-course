package com.estudos.microsservicos.hroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.estudos.microsservicos.hroauth.entity.User;
import com.estudos.microsservicos.hroauth.feignClients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User us = userFeignClient.findByEmail(email).getBody();
		if(us == null) {
			throw new IllegalArgumentException("Email not found !");
		}
		return us;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User us = userFeignClient.findByEmail(username).getBody();
		if(us == null) {
			throw new UsernameNotFoundException("Username not found !");
		}
		return us;
	
	}
}
