package com.slrp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.Servicer;


@Repository
public interface ServicerRepository extends CrudRepository<Servicer, Long> {
	List<Servicer> findServicerByName(String s);
}

