package com.estudos.microsservicos.hrworker.Service;

import org.springframework.stereotype.Service;

import com.estudos.microsservicos.hrworker.entity.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		return new Payment("BOB", 200.0, days);
	}
}
