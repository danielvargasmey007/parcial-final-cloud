package com.cloud.bookings.services;

import java.util.List;

import com.cloud.bookings.domain.Booking;

public interface BookingService {

    List<Booking> getBooking();

    Booking createBooking(Booking booking);

    Booking getBookingById(Long id);

    Long deleteBookingById(Long id);

    List<Booking> getBookingByUserId(Long id);

}
