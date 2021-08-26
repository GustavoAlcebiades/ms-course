package com.estudos.microsservicos.hrpayroll.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.microsservicos.hrpayroll.entity.Payment;
import com.estudos.microsservicos.hrpayroll.entity.Worker;
import com.estudos.microsservicos.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	//Método responsável pela regra de negócio que recupera os valores da classe worker
	public Payment getPayment(Long workerId, int days) {

		Worker wk = workerFeignClient.getOneWorker(workerId).getBody();
		return new Payment(wk.getName(), wk.getDailyIncome(), days);
	}
}
