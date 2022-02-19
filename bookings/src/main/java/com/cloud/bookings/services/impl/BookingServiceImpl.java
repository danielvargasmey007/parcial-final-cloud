package com.cloud.bookings.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.bookings.domain.Booking;
import com.cloud.bookings.repositories.BookingRepository;
import com.cloud.bookings.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
    
    private BookingRepository bookingRepository;
    
    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getBooking() {
        return this.bookingRepository.findAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return this.bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Long deleteBookingById(Long id) {
        this.bookingRepository.delete(new Booking(id));
        return id;
    }

    @Override
    public List<Booking> getBookingByUserId(Long id) {
        return this.bookingRepository.findByUserId(id);
    }

}
