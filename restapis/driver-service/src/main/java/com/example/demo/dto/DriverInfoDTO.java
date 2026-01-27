package com.example.demo.dto;

import com.example.demo.entities.DriverStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverInfoDTO {

	Integer driver_id;
	String driver_license;
	String driver_license_path;
	String pan_card;
	Integer account_no;
	Integer user_id;
	@Enumerated(EnumType.STRING )
	DriverStatus driver_status;
	
}
