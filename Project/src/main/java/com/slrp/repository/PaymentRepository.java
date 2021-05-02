package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Payment;


@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {}


