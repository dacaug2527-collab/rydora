package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverInfoDTO {

	private Integer driverId;
	private String driverLicense;
	private String driverLicensePath;
	private String panCard;
	private String accountNo;
	private Integer userId;
	private Boolean driverStatus;

	
}
