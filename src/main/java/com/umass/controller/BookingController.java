package com.umass.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umass.model.Booking;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public interface BookingController {
	@Operation(summary = "Get a list of bookings")
	@GetMapping(path = "/private/bookings", produces = "application/json", consumes = "application/x")
	public ResponseEntity<List<Booking>> getBookings(@RequestBody Booking booking);

	@Operation(summary = "Get a list of bookings which needs approval")
	@PostMapping(path = "/private/bookings/status.unapproved", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Booking>> getBookingsInRequestedStatus(@RequestBody Booking booking);

	@Operation(summary = "Create a new booking")
	@PostMapping(path = "/private/bookings", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Booking>> createBooking(@RequestBody List<Booking> bookings);

	@Operation(summary = "Update booking status")
	@PutMapping(path = "/private/bookings/status", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<Booking>> updateBookingStatus(@RequestBody List<Booking> bookings);

}
