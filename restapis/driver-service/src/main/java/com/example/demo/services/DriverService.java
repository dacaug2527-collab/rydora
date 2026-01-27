package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverInfoDTO;
import com.example.demo.entities.DriverInfo;
import com.example.demo.entities.DriverStatus;
import com.example.demo.entities.Users;
import com.example.demo.repositories.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverrepository;
	
	public List<DriverInfo> getAll(){
		return driverrepository.findAll();
	}
	
	public DriverInfo getOne(int id) {
		DriverInfo di = null;
		Optional<DriverInfo> odi  = driverrepository.findById(id);
		try {
			di = odi.get();
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return di;
	}
	
	
	public DriverInfo registerExtraDriverDetails(DriverInfo driverinfo){
		return driverrepository.save(driverinfo);
	}
	
	 //fetchForUpdate
	public DriverInfoDTO getForUpdate(Integer driverid) {
		  DriverInfo driver = getOne(driverid);
		  DriverInfoDTO ddto = new DriverInfoDTO();
		  ddto.setDriver_license(driver.getDriver_license());
		  ddto.setDriver_license_path(driver.getDriver_license_path());
		  ddto.setPan_card(driver.getPan_card());
		  ddto.setAccount_no(driver.getAccount_no());
		  ddto.setDriver_id(driver.getDriver_id());
		  
		  return ddto;
		  
	}
	
	//Update
	public DriverInfo updateData(DriverInfoDTO didto) {
		DriverInfo driver = getOne(didto.getDriver_id());
		driver.setDriver_license(didto.getDriver_license());
		driver.setPan_card(didto.getPan_card());
		driver.setAccount_no(didto.getAccount_no());
		driver.setDriver_license_path(didto.getDriver_license_path());
		return driverrepository.save(driver);
	}
	
	//available driver
	public List<DriverInfo> availableDriver() {
		
	     return driverrepository.availableDriver(DriverStatus.AVAILABLE);
	}
}
