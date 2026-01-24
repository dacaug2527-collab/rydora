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

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;


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
	public Users register(@RequestBody Users user) {
	    return usersservice.registerUser(user);
	}
	
	@PostMapping("/login")
	public Users login(@RequestBody Users user) {
	    return usersservice.login(user.getEmail(), user.getPassword());
	}
	
	//PUT--Method /users/update/{id}

	@PutMapping("/update/{id}")
 	public Users updateUser(@PathVariable int id, @RequestBody Users user) {
	    return usersservice.updateUser(id, user);
	}



	

	
	
}
