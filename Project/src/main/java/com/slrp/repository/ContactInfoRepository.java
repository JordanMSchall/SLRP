package com.slrp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.ContactInfo;

@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {}
