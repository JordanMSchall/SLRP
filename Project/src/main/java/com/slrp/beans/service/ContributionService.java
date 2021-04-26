package com.slrp.beans.service;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.Contribution;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class ContributionService {

	public void makeContribution(Contribution cont) {
		// TODO
	}
	
	public void getContributions(Contribution cont) {
		// TODO
	}

}
