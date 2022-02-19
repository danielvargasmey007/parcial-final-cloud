package com.cloud.bookings.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.bookings.domain.Booking;
import com.cloud.bookings.dto.BookingDTO;
import com.cloud.bookings.services.BookingService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/bookings")
public class BookingController extends BaseController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @CircuitBreaker(name = "BOOKING",  fallbackMethod = "getBookingFallBack")
    public List<BookingDTO> getBooking() throws Exception {
        List<Booking> response = this.bookingService.getBooking();
        List<BookingDTO> responseDTO = response
                .stream()
                .map(b -> modelMapper.map(b, BookingDTO.class))
                .collect(Collectors.toList());


        return responseDTO;
    }
    
    public List<BookingDTO> getBookingFallBack() throws Exception {
        List<Booking> response = this.bookingService.getBooking();
        List<BookingDTO> responseDTO = response
                .stream()
                .map(b -> modelMapper.map(b, BookingDTO.class))
                .collect(Collectors.toList());


        return responseDTO;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookingDTO createUser(@Valid @RequestBody BookingDTO bookingDTO) throws Exception {
        Booking booking = this.bookingService
                .createBooking(modelMapper.map(bookingDTO, Booking.class));
        return modelMapper.map(booking, BookingDTO.class);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public BookingDTO getBookingById(@Valid @PathVariable Long id) throws Exception {
        Booking booking = this.bookingService.getBookingById(id);
        return modelMapper.map(booking, BookingDTO.class);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<BookingDTO> getBookingByUserId(@Valid @PathVariable Long id) throws Exception {
        List<Booking> booking = this.bookingService.getBookingByUserId(id);
        List<BookingDTO> responseDTO = booking
                .stream()
                .map(b -> modelMapper.map(b, BookingDTO.class))
                .collect(Collectors.toList());
        return responseDTO;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Long deleteMovie(@Valid @PathVariable Long id) throws Exception {
        return this.bookingService.deleteBookingById(id);
    }
}
