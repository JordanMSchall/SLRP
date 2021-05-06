package com.slrp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.Borrower;
import com.slrp.model.PendingServicer;
import com.slrp.model.Person;
import com.slrp.model.Servicer;
import com.slrp.repository.PendingServicerRepository;
import com.slrp.repository.ServicerRepository;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class ServicerService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	ServicerRepository servicerRepository;

	@Autowired
	PendingServicerRepository pendingServicerRepository;

	public void addUserDefinedServicer(String s) {
		List<Servicer> results = servicerRepository.findServicerByName(s);
		if (results.isEmpty()) {
			Servicer se = new Servicer();
			se.setName(s);
			PendingServicer ps = new PendingServicer();
			ps.setServicer(se);
			servicerRepository.save(se);
			pendingServicerRepository.save(ps);
			
		}	
	}
	
	public Servicer getServicerByName(String s) {
		List<Servicer> results = servicerRepository.findServicerByName(s);
		if (results.isEmpty()) {
			addUserDefinedServicer(s);	
		}	
		results = servicerRepository.findServicerByName(s);
		return results.get(0);
	}

}
