package com.slrp.beans.service;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.Contract;
import com.slrp.model.User;

@Component
@Scope("singleton")
@PropertySource("classpath:legal.properties")
public class LegalService {

	public Contract getNewContract(String agreementType) {
		//TODO
		return null;
	}
	
	
	public Contract signContract(User user, Contract agreement) {
		//TODO
		return null;
	}
	
	public Contract ammendContract(User user, Contract agreement) {
		//TODO
		return null;
	}
	
	public Contract voidContract(User user, Contract agreement) {
		//TODO
		return null;
	}
	
	public Contract deleteContract(User user, Contract agreement) {
		//TODO
		return null;
	}
	

}
