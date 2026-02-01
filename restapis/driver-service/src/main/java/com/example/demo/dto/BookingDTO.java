package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.entities.BookingStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDTO {


	    private Integer bookingId;
	    private String startLocation;
	    private String endLocation;

	    private LocalDateTime bookingDateTime;
	    private LocalDate startDate;
	    private LocalDate endDate;

	    private BookingStatus bookingStatus;
	    private String firstName;
	    private String lastName;

	    private Integer userId;
	    private Integer driverId;
	}

