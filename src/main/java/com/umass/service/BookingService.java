package com.umass.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShiftRepository shiftRepository;

	@Override
	public ResponseEntity<List<Booking>> getBookings(Booking booking) {
		List<Booking> bookings = bookingRepository.findByStartTimeBetween(booking.getStartTime(), booking.getEndTime());
		return ResponseEntity.ok(bookings);	}

	@Override
	public ResponseEntity<List<Booking>> createBooking(List<Booking> bookings) {

		List<Booking> resultBookings = new ArrayList<Booking>();
		for (Booking booking : bookings) {

			Optional<Shift> shiftOptional = shiftRepository.findById(booking.getShiftId());
			Shift shift = shiftOptional.get();
			User user = userRepository.findByUsername("arushi");

			if (user == null) {
				continue;
			} else if (!shiftOptional.isPresent()) {
				continue;
			}

			if (shift.getCapacity() > 0) {
				Booking createdBooking = Booking.builder().userId(user.getId()).type(shift.getType())
						.shiftId(shift.getId()).status(BookingStatus.REQUESTED).startTime(shift.getStartTime())
						.endTime(shift.getEndTime()).id(String.valueOf(System.currentTimeMillis())).build();

				resultBookings.add(createdBooking);

			}

		}

		bookingRepository.saveAll(resultBookings);
		return ResponseEntity.ok().body(resultBookings);
	}

	@Override
	public ResponseEntity<List<Booking>> updateBookingStatus(List<Booking> bookings) {
		List<Booking> bookingsToApprove = bookingRepository.findAllById(extractIds(bookings));
		List<Booking> approvedBookings = new ArrayList<Booking>();
		String approverName = findAnyApproverName(bookings);
		if(Objects.isNull(approverName)) {
			return ResponseEntity.ok().body(Collections.EMPTY_LIST);
		}
		for (Booking booking : bookingsToApprove) {
			if (BookingStatus.REQUESTED.equals(booking.getStatus())) {
				booking.setApproverUsername(approverName);
				booking.setStatus(BookingStatus.APPROVED);
				approvedBookings.add(booking);
			}
		}
		bookingRepository.saveAll(approvedBookings);
		return ResponseEntity.ok().body(approvedBookings);
	}

	private static List<String> extractIds(List<Booking> bookings) {
		List<String> ids = new ArrayList<>();
		for (Booking booking : bookings) {
			ids.add(booking.getId());
		}
		return ids;
	}

	public static String findAnyApproverName(List<Booking> bookings) {
		for (Booking booking : bookings) {
			String approverName = booking.getApproverUsername();
			if (approverName != null && !approverName.isEmpty()) {
				return approverName;
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<List<Booking>> getBookingsInRequestedStatus(Booking booking) {
		List<Booking> bookings = bookingRepository.findByStartTimeBetweenAndStatus(booking.getStartTime(), booking.getEndTime(), BookingStatus.REQUESTED);
		return ResponseEntity.ok(bookings);
	}

}
