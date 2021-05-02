package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.slrp.model.Contract;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long> {}
