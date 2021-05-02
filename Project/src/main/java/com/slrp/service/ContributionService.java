package com.slrp.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.Contribution;
import com.slrp.repository.ContractRepository;
import com.slrp.repository.ContributionRepository;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class ContributionService {
	
	private static final Logger logger = LoggerFactory.getLogger(ContributionService.class);
	@Autowired
	ContributionRepository contributionRepository;
	
	public void makeContribution(Contribution cont) {
		contributionRepository.save(cont);
	}
	
	public Iterable<Contribution> getContributions(Contribution cont) {
		return contributionRepository.findAll();
		}

	public Optional<Contribution> getContribution(Contribution c) {
		return contributionRepository.findById(c.getId());
	}

	public void deleteContribution(Contribution c) {
		contributionRepository.delete(c);
		
	}

	public void createContribution(Contribution c) {
		makeContribution(c);	
	}

}
