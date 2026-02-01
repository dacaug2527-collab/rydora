package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.BookingDTO;
import com.example.demo.entities.Booking;
import com.example.demo.entities.BookingStatus;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	
	@Query("select b from Booking b where b.driver.driverId = ?1 ")
	public List<Booking> driverBookingHistory(Integer did);

	@Query("select b from Booking b where b.bookingStatus = ?1")
	public List<Booking> pendingList(BookingStatus pending);
}
