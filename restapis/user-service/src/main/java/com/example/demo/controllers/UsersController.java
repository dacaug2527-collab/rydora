package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersService usersservice;
	
	@GetMapping("/all")
	public List<Users> getAll(){
		return usersservice.getAllUsers();
	}
	@PostMapping("/register")
	public String register(@RequestBody Users user) {
		usersservice.register(user);
		return "Registered Sucessfully";
	}
	
	
}
