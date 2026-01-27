package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	Integer user_id;
	String user_name;
	String password;
	String email;
	String contact_no;
	String permanent_address;
	String current_address;
	String first_name;
	String last_name;
	String aadhar;
	String aadhar_img_path;
	Integer role_id;
	
	
	
}
