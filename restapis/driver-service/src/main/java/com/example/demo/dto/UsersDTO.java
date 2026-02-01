package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersDTO {
	
	    private Integer userId;

	    private String userName;
	    
	    private String password;

	    private String email;

	    private String contactNo;

	    private String permanentAddress;

	    private String currentAddress;

	    private String firstName;

	    private String lastName;

	    private String aadhar;

	    private String aadharImgPath;

	    private Integer roleId;
	

}
