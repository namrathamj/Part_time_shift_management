package com.umass.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.umass.model.Booking;
import com.umass.model.BookingStatus;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String>{
    
	List<Booking> findByStartTimeBetween(Date startTime, Date endTime);

	List<Booking> findByStartTimeBetweenAndStatus(Date startTime, Date endTime, BookingStatus requested);
}
