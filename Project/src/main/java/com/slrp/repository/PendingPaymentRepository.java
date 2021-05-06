package com.slrp.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.PendingPayment;

@Repository
public interface PendingPaymentRepository extends CrudRepository<PendingPayment, Long> {

}

