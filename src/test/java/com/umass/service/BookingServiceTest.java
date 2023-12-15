package com.umass.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.umass.model.Booking;
import com.umass.model.BookingStatus;
import com.umass.repository.BookingRepository;
import com.umass.repository.ShiftRepository;
import com.umass.repository.UserRepository;

class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ShiftRepository shiftRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void testGetBookings() {
        // Mock data
        Booking booking = new Booking();
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingRepository.findAll()).thenReturn(bookings);

        // Execute the service method
        ResponseEntity<List<Booking>> responseEntity = bookingService.getBookings(booking);

        // Verify the results
        assertEquals(bookings, responseEntity.getBody());
    }

    @Test
    void testUpdateBookingStatus_NoApproverName() {
        // Mock data
        Booking booking = new Booking();
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingRepository.findAllById(Collections.singletonList(booking.getId()))).thenReturn(bookings);

        // Execute the service method
        ResponseEntity<List<Booking>> responseEntity = bookingService.updateBookingStatus(bookings);

        // Verify the results
        assertEquals(Collections.emptyList(), responseEntity.getBody());
        verify(bookingRepository, never()).saveAll(anyList());
    }

    @Test
    void testUpdateBookingStatus_WithApproverName() {
        // Mock data
        Booking booking = new Booking();
        booking.setStatus(BookingStatus.REQUESTED);
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingRepository.findAllById(Collections.singletonList(booking.getId()))).thenReturn(bookings);

        // Execute the service method
        ResponseEntity<List<Booking>> responseEntity = bookingService.updateBookingStatus(bookings);

        // Verify the results
        assertEquals(bookings, responseEntity.getBody());
        verify(bookingRepository, times(1)).saveAll(anyList());
    }

    @Test
    void testUpdateBookingStatus_BookingAlreadyApproved() {
        // Mock data
        Booking booking = new Booking();
        booking.setStatus(BookingStatus.APPROVED);
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingRepository.findAllById(Collections.singletonList(booking.getId()))).thenReturn(bookings);

        // Execute the service method
        ResponseEntity<List<Booking>> responseEntity = bookingService.updateBookingStatus(bookings);

        // Verify the results
        assertEquals(Collections.emptyList(), responseEntity.getBody());
        verify(bookingRepository, never()).saveAll(anyList());
    }

    @Test
    void testUpdateBookingStatus_BookingRequested() {
        // Mock data
        Booking booking = new Booking();
        booking.setStatus(BookingStatus.REQUESTED);
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);

        when(bookingRepository.findAllById(Collections.singletonList(booking.getId()))).thenReturn(bookings);

        // Execute the service method
        ResponseEntity<List<Booking>> responseEntity = bookingService.updateBookingStatus(bookings);

        // Verify the results
        assertEquals(bookings, responseEntity.getBody());
        verify(bookingRepository, times(1)).saveAll(bookings);
    }

    @Test
    void testUpdateBookingStatus_MultipleBookings() {
        // Mock data
        Booking booking1 = new Booking();
        booking1.setStatus(BookingStatus.REQUESTED);
        Booking booking2 = new Booking();
        booking2.setStatus(BookingStatus.REQUESTED);
        List<Booking> bookings = Arrays.asList(booking1, booking2);

        when(bookingRepository.findAllById(Arrays.asList(booking1.getId(), booking2.getId()))).thenReturn(bookings);

        // Execute the service method
        ResponseEntity<List<Booking>> responseEntity = bookingService.updateBookingStatus(bookings);

        // Verify the results
        assertEquals(bookings, responseEntity.getBody());
        verify(bookingRepository, times(1)).saveAll(bookings);
    }

    // Add more test cases based on your specific scenarios
}

