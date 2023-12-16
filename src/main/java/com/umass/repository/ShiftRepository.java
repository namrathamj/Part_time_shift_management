package com.umass.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.umass.model.Shift;

public interface ShiftRepository extends MongoRepository<Shift, String>{
    
	List<Shift> findByStartTimeBetween(Date startTime, Date endTime);
}
