package com.umass.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.umass.model.Booking;


public interface BookingRepository extends MongoRepository<Booking, String>{
    
	Booking findByStartTimeBetween(Date startTime, Date endTime);
}
