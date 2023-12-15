package com.umass.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.umass.model.Booking;

@Controller
public interface BookingController {
	
	@GetMapping(path = "/private/bookings", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Booking>> getBookings(@RequestBody Booking booking);

	@PostMapping(path = "/private/bookings", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Booking>> createBooking(@RequestBody List<Booking> bookings);

}
