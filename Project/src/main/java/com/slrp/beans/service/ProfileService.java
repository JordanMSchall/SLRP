package com.slrp.beans.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.slrp.model.Borrower;
import com.slrp.model.User;

@Service
@PropertySource("classpath:application.properties")
public class ProfileService {
	  private static final Logger logger = LoggerFactory.getLogger(ProfileService.class);

	
	@Value("${profile.version}")
	private String version;
	
	public void createProfile(User user) {
		// TODO
		logger.info("\n Creating a profile for user:" + user.toString());
	}
	
	public void deleteProfile(User user, String profileType) {
		// TODO
	}
	
	public void updateProfile(User user, String profileType) {
		// TODO
	}
	
	public void getProfile(User user) {
		// TODO
	}

	public void createProfile(Borrower b) {
		// TODO Auto-generated method stub
		
	}

	public static String addAddress() {
		// TODO Auto-generated method stub
		return "<button>Add Address!</button>";
	}
}
