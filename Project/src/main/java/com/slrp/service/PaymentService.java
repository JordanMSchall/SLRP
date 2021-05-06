package com.slrp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.Contribution;
import com.slrp.model.Loan;
import com.slrp.model.Payment;
import com.slrp.model.PendingPayment;
import com.slrp.repository.ContributionRepository;
import com.slrp.repository.PaymentRepository;
import com.slrp.repository.PendingPaymentRepository;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class PaymentService {
	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	PendingPaymentRepository pendingPaymentRepository;

	@Autowired
	ContributionRepository contributionRepository;

	public void createPayment(Payment p) {
		paymentRepository.save(p);
	}

	public void deletePayment(Payment p) {
		paymentRepository.delete(p);
	}

	public Optional<Payment> getPayment(Payment p) {
		return paymentRepository.findById(p.getId());
	}

	public Iterable<Payment> getPayments() {
		return paymentRepository.findAll();
	}

	public void makePending(PendingPayment pp) {
		pendingPaymentRepository.save(pp);
	}

	public List<Payment> getPaymentsByLoan(Loan l) {
		return paymentRepository.findPaymentByLoan(l);
	}

	public void createContribution(Contribution c) {
		contributionRepository.save(c);

	}

	public void updatePayment(Payment p) {
		paymentRepository.save(p);

	}

}
