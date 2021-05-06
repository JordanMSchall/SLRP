package com.slrp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.ContactInfo;
import com.slrp.model.School;


@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {

	List<School> findSchoolByContact(ContactInfo contactInfo);}

