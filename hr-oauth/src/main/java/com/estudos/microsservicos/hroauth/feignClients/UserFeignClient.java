package com.estudos.microsservicos.hroauth.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estudos.microsservicos.hroauth.entity.User;

@Component
@FeignClient(name= "hr-user", path = "/users")
public interface UserFeignClient {

	@GetMapping("/search")
   ResponseEntity<User> findByEmail(@RequestParam String email);
}
