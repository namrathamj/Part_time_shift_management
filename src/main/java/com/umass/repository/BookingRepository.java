package com.umass.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.umass.model.Booking;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String>{
    
	List<Booking> findByStartTimeBetween(Date startTime, Date endTime);
}
