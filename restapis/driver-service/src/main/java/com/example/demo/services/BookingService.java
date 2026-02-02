package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingDTO;
import com.example.demo.entities.Booking;
import com.example.demo.entities.BookingStatus;
import com.example.demo.entities.DriverInfo;
import com.example.demo.entities.Users;
import com.example.demo.repositories.BookingRepository;


@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	//get by id
	public Booking getOneBooking(Integer id) {
		Booking b = null;
		Optional<Booking> ob = bookingRepository.findById(id);
		try {
			 b = ob.get();
			
		}catch(NoSuchElementException ns) {
			ns.printStackTrace();
		}
		return b;
	}


	
	//access booking history
	public List<BookingDTO> bookingHistory(Integer userid) {
		List<DriverInfo> driver = bookingRepository.getDriverId(userid);
		Integer driverId = 0;
		for (DriverInfo d : driver) {
		    driverId = d.getDriverId();
		}
		
	    List<Booking> bookings = bookingRepository.driverBookingHistory(driverId);
	    List<BookingDTO> bookingDTOs = new ArrayList<>();

	    for (Booking b : bookings) {
	        BookingDTO bd = new BookingDTO();
	        bd.setStartDate(b.getStartDate());
	        bd.setEndDate(b.getEndDate());
	        bd.setStartLocation(b.getStartLocation());
	        bd.setEndLocation(b.getEndLocation());

	        Users u = b.getUser();
	        if (u != null) {
	            bd.setFirstName(u.getFirstName());
	            bd.setLastName(u.getLastName());
	        }
	        bookingDTOs.add(bd);
	    }

	    return bookingDTOs;
	}
	//newRequest
	public List<BookingDTO> newRequest(){
		List<Booking> bookings = bookingRepository.pendingList(BookingStatus.PENDING);
		List<BookingDTO> bookingDTOs = new ArrayList<>();

	    for (Booking b : bookings) {
	        BookingDTO bd = new BookingDTO();
	        bd.setStartDate(b.getStartDate());
	        bd.setEndDate(b.getEndDate());
	        bd.setStartLocation(b.getStartLocation());
	        bd.setEndLocation(b.getEndLocation());

	        Users u = b.getUser();
	        if (u != null) {
	            bd.setFirstName(u.getFirstName());
	            bd.setLastName(u.getLastName());
	        }
	        bookingDTOs.add(bd);
	    }

	    return bookingDTOs;
		 
	}


      //acceptBooking
	public BookingDTO acceptBooking(Integer bookingId) {
		
		Booking booking = getOneBooking(bookingId);
		
		if(booking.getBookingStatus() == BookingStatus.PENDING) {
			   
			   booking.setBookingStatus(BookingStatus.ACCEPTED);
			   bookingRepository.save(booking);
			   
		}
		BookingDTO bd = new BookingDTO();
		bd.setBookingId(booking.getBookingId());
		return bd;
		
	}
}

