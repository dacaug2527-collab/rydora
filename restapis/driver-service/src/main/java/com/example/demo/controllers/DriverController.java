package com.example.demo.controllers;

import java.util.List;
import com.example.demo.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.DriverInfoDTO;
import com.example.demo.entities.DriverInfo;
import com.example.demo.services.BookingService;
import com.example.demo.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private PaymentService paymentService;
	@Autowired
	private DriverService driverService;
	@Autowired
	private BookingService bookingService;

	
	@GetMapping("/all")
	public List<DriverInfo> getAll() {
		return driverService.getAll();
	}
	
	@PostMapping("/extradriverinfo")
	public DriverInfo registerDriverDetails(@RequestBody DriverInfo driverinfo){
		return driverService.registerExtraDriverDetails(driverinfo);
	}
	
	
	@GetMapping("/fetchUpdate/{driverid}")
	public DriverInfoDTO getForUpdate(@PathVariable Integer driverid) {
		return driverService.getForUpdate(driverid);
	}
	
	@PutMapping("/update")
	public DriverInfo updateData(@RequestBody DriverInfoDTO didto) {
		return driverService.updateData(didto);
	}
	
	@GetMapping("/bookinghistory/{userId}")
	public List<BookingDTO> bookingHistroy(@PathVariable Integer userId) {
		return bookingService.bookingHistory(userId);
	}
	@GetMapping("/newrequest")
	public List<BookingDTO> newRequest(){
		return bookingService.newRequest();
	}
	
	@PutMapping("/accept/{bookingId}")
	public BookingDTO acceptBooking(@PathVariable Integer bookingId) {
		return bookingService.acceptBooking(bookingId);
	}
	
	@PutMapping("/available/{driverId}")
	public String Available(@PathVariable Integer driverId) {
		if(driverService.available(driverId)) {
			return "AVAILABLE";
		}
		return "NOT AVAILABLE";
	}
	
	@PutMapping("/notavailable/{driverId}")
	public String notAvailable(@PathVariable Integer driverId) {
		if(driverService.notAvailable(driverId)) {
			return "NOT AVAILABLE";
		}
		return "AVAILABLE";
	}
	
	@PutMapping("/startkm/{paymentId}")
	public String startKm(@PathVariable Integer paymentId, @RequestParam Double startkm) {
	   paymentService.startKM(paymentId, startkm);
	   return "Inserted";
	}
	
	@PutMapping("/endkm/{paymentId}")
	public String endKm(@PathVariable Integer paymentId, @RequestParam Double endkm) {
	   paymentService.endKM(paymentId, endkm);
	   return "Inserted";
	}
	
	@GetMapping("/totalkm/{paymentId}")
	public Double totalKm(@PathVariable Integer paymentId) {
		return paymentService.totalKM(paymentId);
	}
	
	
}
