package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.DriverInfoDTO;
import com.example.demo.entities.DriverInfo;
import com.example.demo.entities.Users;
import com.example.demo.services.BookingService;
import com.example.demo.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	DriverService driverService;
	@Autowired
	BookingService bookingService;
	
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
	
	@GetMapping("/bookinghistory/{did}")
	public List<BookingDTO> bookingHistroy(@PathVariable Integer did) {
		return bookingService.bookingHistory(did);
	}
	@GetMapping("/newrequest")
	public List<BookingDTO> newRequest(){
		return bookingService.newRequest();
	}
	/*
	 * @GetMapping("/availabledriver") public List<DriverInfo> availableDriver() {
	 * 
	 * return driverservice.availableDriver(); }
	 */
	
}
