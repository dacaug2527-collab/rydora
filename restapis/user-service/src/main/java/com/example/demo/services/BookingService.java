package com.example.demo.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.enums.BookingStatus;
import com.example.demo.repositories.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    //Service method for Booking Driver
    public Booking createBooking(Booking booking) {

        booking.setBookingStatus(BookingStatus.PENDING); //fixed
        booking.setBookingDateTime(LocalDateTime.now());

        Booking savedBooking = bookingRepository.save(booking);

        System.out.println("Booking successfully created for Booking ID: "
                + savedBooking.getBookingId());

        return savedBooking;
    }
    //Service Method for Cancel Booking
    public String cancelBooking(Integer bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Can not cancelled Because trip already started
        if (!LocalDate.now().isBefore(booking.getStartDate())) {
            return "Cannot cancel booking. Trip already started.";
        }

        booking.setBookingStatus(BookingStatus.CANCELLED); 
        bookingRepository.save(booking);

        System.out.println("Booking cancelled successfully for Booking ID: "
                + bookingId);

        return "Booking cancelled successfully";
    }
}
