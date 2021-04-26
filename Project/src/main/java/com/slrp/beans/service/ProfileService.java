package com.slrp.beans.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.User;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class ProfileService {
	
	@Value("${profile.version}")
	private String version;
	
	public void createProfile(User user, String profileType) {
		// TODO
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
}
