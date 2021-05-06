package com.slrp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Loan;
import com.slrp.model.Payment;


@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
	List<Payment> findPaymentByLoan(Loan l);
}


