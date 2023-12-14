package com.umass.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.umass.model.Shift;

public interface ShiftRepository extends MongoRepository<Shift, String>{
    
	Shift findByStartTimeBetween(Date startTime, Date endTime);
}
