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

import com.example.demo.dto.DriverInfoDTO;
import com.example.demo.entities.DriverInfo;
import com.example.demo.entities.Users;
import com.example.demo.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	DriverService driverservice;
	
	@GetMapping("/all")
	public List<DriverInfo> getAll() {
		return driverservice.getAll();
	}
	
	@PostMapping("/extradriverinfo")
	public DriverInfo registerDriverDetails(@RequestBody DriverInfo driverinfo){
		return driverservice.registerExtraDriverDetails(driverinfo);
	}
	
	
	@GetMapping("/fetchUpdate/{driverid}")
	public DriverInfoDTO getForUpdate(@PathVariable Integer driverid) {
		return driverservice.getForUpdate(driverid);
	}
	
	@PutMapping("/update")
	public DriverInfo updateData(@RequestBody DriverInfoDTO didto) {
		return driverservice.updateData(didto);
	}
	
	@GetMapping("/availabledriver")
	public List<DriverInfo> availableDriver() {
		
		return driverservice.availableDriver();
	}
	
}
