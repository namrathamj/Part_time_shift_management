package com.umass.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.umass.model.Booking;
import com.umass.service.BookingService;

class BookingControllerTest {

    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController = new BookingController() {
        @Override
        public ResponseEntity<List<Booking>> getBookings(Booking booking) {
            return null;
        }

        @Override
        public ResponseEntity<List<Booking>> createBooking(List<Booking> bookings) {
            return null;
        }

        @Override
        public ResponseEntity<List<Booking>> updateBookingStatus(List<Booking> bookings) {
            return null;
        }
    };

    @Test
    void testGetBookings() {
        // Mock data
        Booking booking = new Booking();
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingService.getBookings(booking)).thenReturn(ResponseEntity.ok(bookings));

        // Execute the controller method
        ResponseEntity<List<Booking>> responseEntity = bookingController.getBookings(booking);

        // Verify the results
        assertEquals(bookings, responseEntity.getBody());
        verify(bookingService, times(1)).getBookings(booking);
    }

    @Test
    void testCreateBooking() {
        // Mock data
        Booking booking = new Booking();
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingService.createBooking(bookings)).thenReturn(ResponseEntity.ok(bookings));

        // Execute the controller method
        ResponseEntity<List<Booking>> responseEntity = bookingController.createBooking(bookings);

        // Verify the results
        assertEquals(bookings, responseEntity.getBody());
        verify(bookingService, times(1)).createBooking(bookings);
    }

    @Test
    void testUpdateBookingStatus() {
        // Mock data
        Booking booking = new Booking();
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingService.updateBookingStatus(bookings)).thenReturn(ResponseEntity.ok(bookings));

        // Execute the controller method
        ResponseEntity<List<Booking>> responseEntity = bookingController.updateBookingStatus(bookings);

        // Verify the results
        assertEquals(bookings, responseEntity.getBody());
        verify(bookingService, times(1)).updateBookingStatus(bookings);
    }
}
