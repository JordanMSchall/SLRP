package com.slrp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.slrp.model.ContactInfo;
import com.slrp.model.Organization;
import com.slrp.model.School;
import com.slrp.repository.OrganizationRepository;
import com.slrp.repository.SchoolRepository;

@Component
@Scope("singleton")
@PropertySource("classpath:application.properties")
public class OrgService {
	private static final Logger logger = LoggerFactory.getLogger(OrgService.class);
	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	SchoolRepository schoolRepository;

	public void createOrg(Organization org) {
		organizationRepository.save(org);
	}

	public School getSchoolByContactInfo(ContactInfo contactInfo) {
		List<School> results = schoolRepository.findSchoolByContact(contactInfo);
		if (results.isEmpty()) {
			return null;
		}
		return results.get(0);
	}

	public void createSchool(School s) {
		schoolRepository.save(s);
	}

	public void updateSchool(School school) {
		schoolRepository.save(school);

	}

}
