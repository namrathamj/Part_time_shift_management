package com.umass.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.umass.controller.BookingController;
import com.umass.model.Booking;
import com.umass.model.BookingStatus;
import com.umass.model.Shift;
import com.umass.model.User;
import com.umass.repository.BookingRepository;
import com.umass.repository.ShiftRepository;
import com.umass.repository.UserRepository;

@Service
public class BookingService implements BookingController {

	@Autowired
	private BookingRepository boookingRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	@Override
	public ResponseEntity<List<Booking>> getBookings(Booking booking) {
		return null;
	}

	@Override
	public ResponseEntity<List<Booking>> createBooking(List<Booking> bookings) {
//		 1. check that given userId really exists 
//		check that given shift time exists and haas capacity as available s
//		create a booking -- race condition 
//		format and return result
//		put a request for approval 
		
		List<Booking> resultBookings = new ArrayList<Booking>();
		for(Booking booking: bookings) {
			
			Optional<Shift> shiftOptional = shiftRepository.findById(booking.getShiftId());
			Shift shift = shiftOptional.get();
			User user = userRepository.findByUsername("arushi");


			if(user == null) {
				continue;
			} else if (!shiftOptional.isPresent()) {
				continue;
			}
			
			if(shift.getCapacity()>0) {		   
				Booking createdBooking = Booking.builder()
						.userId(user.getId())
						.type(shift.getType())
						.shiftId(shift.getId())
						.status(BookingStatus.REQUESTED)
						.startTime(shift.getStartTime())
						.endTime(shift.getEndTime())
						.id(String.valueOf(System.currentTimeMillis()))
						.build();
	
				resultBookings.add(createdBooking);
				
			}

		}	
		boookingRepository.saveAll(resultBookings);
		return ResponseEntity.ok().body(resultBookings);
	}

}
