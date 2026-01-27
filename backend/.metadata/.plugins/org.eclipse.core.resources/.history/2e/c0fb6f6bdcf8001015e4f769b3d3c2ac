package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersrepository;
	
	public List<Users>getAllUsers(){
		return usersrepository.findAll();
	}
	
	public Users register(Users user) {
		return usersrepository.save(user);
	}
}
