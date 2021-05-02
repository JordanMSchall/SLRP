package com.slrp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import org.springframework.stereotype.Component;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slrp.model.Contract;
import com.slrp.repository.ContractRepository;


@Component
@PropertySource("classpath:application.properties")
public class LegalService {
	private static final Logger logger = LoggerFactory.getLogger(LegalService.class);
	@Autowired
	ContractRepository contractRepository;


	public void createContract(Contract contract) {
		contractRepository.save(contract);
	}

	public void deleteContract(Contract contract) {
		contractRepository.delete(contract);
	}

	public Optional<Contract> getContract(Contract contract) {
		return contractRepository.findById(contract.getId());
	}

}
