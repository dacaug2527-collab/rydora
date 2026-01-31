package com.example.demo.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.repositories.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {

        booking.setBookingStatus("PENDING");

        // booking date-time set
        booking.setBookingDateTime(LocalDateTime.now());

        // save booking
        Booking savedBooking = bookingRepository.save(booking);

        // ✅ SIMPLE BACKEND MESSAGE (console)
        System.out.println("✅ Booking successfully created. Booking ID: "
                + savedBooking.getBookingId());

        return savedBooking;
    }
}
