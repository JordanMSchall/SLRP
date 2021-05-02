package com.slrp.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.slrp.model.Payment;
import com.slrp.repository.PaymentRepository;

@Component
@PropertySource("classpath:application.properties")
public class PaymentService {
	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	PaymentRepository paymentRepository;

	public void createPayment(Payment loan) {
		paymentRepository.save(loan);
	}

	public void deletePayment(Payment loan) {
		paymentRepository.delete(loan);
	}

	public Optional<Payment> getPayment(Payment loan) {
		return paymentRepository.findById(loan.getId());
	}

	public Iterable<Payment> getPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

}
