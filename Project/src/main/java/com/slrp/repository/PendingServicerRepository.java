package com.slrp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.slrp.model.PendingServicer;

@Repository
public interface PendingServicerRepository extends CrudRepository<PendingServicer, Long> {

}
