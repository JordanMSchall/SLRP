package com.slrp.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.slrp.Application;
import com.slrp.controller.HubController;
import com.slrp.service.ContributionService;
import com.slrp.service.LegalService;
import com.slrp.service.LoanService;
import com.slrp.service.ProfileService;

@SpringBootTest(classes=Application.class)
public class TestRunner {
	@Autowired
	private HubController controller;
	
	@Autowired
	private LoanService loanService;
	
	
	@Autowired
	private ProfileService profileService;
	
	
	@Autowired
	private LegalService legalService;
	
	@Autowired
	private ContributionService contributionService;
	
	@Test
	public void verifyHubController() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void loanServiceTest() {
		assertThat(loanService).isNotNull();
	}
	
	@Test
	public void profileServiceTest() {
		assertThat(profileService).isNotNull();
	}
	
	@Test
	public void legalServiceTest() {
		assertThat(legalService).isNotNull();
	}
	
	@Test
	public void contributionServiceTest() {
		assertThat(contributionService).isNotNull();
	}

}