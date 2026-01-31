package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contact_no")
	private String contactNo;
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(name = "current_address")
	private String currentAddress;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "aadhar")
	private String Aadhar;
	
	@Column(name = "aadhar_img_path")
	private String aadharImgPath;
	@Column(name = "role_id")
	private Integer roleId;
	
	@OneToOne(mappedBy = "user")
	private DriverInfo driverInfo;


	
	
	
}
