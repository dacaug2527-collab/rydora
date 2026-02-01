package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.DriverInfoDTO;
import com.example.demo.entities.DriverInfo;
import com.example.demo.entities.Users;
import com.example.demo.repositories.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverRepository;
	
	
	public List<DriverInfo> getAll(){
		return driverRepository.findAll();
	}
	
	public DriverInfo getOne(int id) {
		DriverInfo di = null;
		Optional<DriverInfo> odi  = driverRepository.findById(id);
		try {
			di = odi.get();
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return di;
	}
	
	
	public DriverInfo registerExtraDriverDetails(DriverInfo driverinfo){
		return driverRepository.save(driverinfo);
	}
	
	 //fetchForUpdate
	public DriverInfoDTO getForUpdate(Integer driverid) {
		  DriverInfo driver = getOne(driverid);
		  DriverInfoDTO ddto = new DriverInfoDTO();
		  ddto.setDriverLicense(driver.getDriverLicense());
		  ddto.setDriverLicensePath(driver.getDriverLicensePath());
		  ddto.setPanCard(driver.getPanCard());
		  ddto.setAccountNo(driver.getAccountNo());
		  ddto.setDriverId(driver.getDriverId());
		  
		  return ddto;
		  
	}
	
	//Update
	public DriverInfo updateData(DriverInfoDTO didto) {
		DriverInfo driver = getOne(didto.getDriverId());
		driver.setDriverLicense(didto.getDriverLicense());
		driver.setPanCard(didto.getPanCard());
		driver.setAccountNo(didto.getAccountNo());
		driver.setDriverLicensePath(didto.getDriverLicensePath());
		return driverRepository.save(driver);
	}
	
	
	//available driver
	/*
	 * public List<DriverInfo> availableDriver() {
	 * 
	 * return driverrepository.availableDriver(DriverStatus.AVAILABLE); }
	 */
}
