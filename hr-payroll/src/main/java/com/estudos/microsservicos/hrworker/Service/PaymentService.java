package com.estudos.microsservicos.hrworker.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estudos.microsservicos.hrworker.entity.Payment;
import com.estudos.microsservicos.hrworker.entity.Worker;

@Service
public class PaymentService {
	
	//Serve para buscar o host declarado no application.properties
	@Value("${hr-worker.host}")
	private String workerHost;
	
	//declarada na classe ApplicationConfig.java responsável por instanciar o restTemplate 
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(Long workerId, int days) {
		Map<String, String> mapUriVariables = new HashMap<>();
		mapUriVariables.put("id", ""+workerId);
		
		Worker wk = restTemplate.getForObject(workerHost + "/workers/{id}",  Worker.class, mapUriVariables);
		return new Payment(wk.getName(), wk.getDailyIncome(), days);
	}
}
