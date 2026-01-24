package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Users;

import com.example.demo.repositories.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users registerUser(Users user) {
        return usersRepository.save(user);
    }
    
    public Users login(String email, String password) {
        Users user = usersRepository.findByEmailAndPassword(email, password);

        if (user != null) {
            System.out.println("Login successful for email: " + email);
        } else {
            System.out.println("Login failed for email: " + email);
        }

        return user;
    }
    
    public Users updateUser(int id, Users updatedUser) {

        Users existingUser = usersRepository.findById(id).orElse(null);

        if (existingUser == null) {
            System.out.println("User not found with id: " + id);
            return null;
        }

        // fields update
        existingUser.setUser_name(updatedUser.getUser_name());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setContact_no(updatedUser.getContact_no());
        existingUser.setPermanent_address(updatedUser.getPermanent_address());
        existingUser.setCurrent_address(updatedUser.getCurrent_address());
        existingUser.setFirst_name(updatedUser.getFirst_name());
        existingUser.setLast_name(updatedUser.getLast_name());
        existingUser.setAadhar(updatedUser.getAadhar());
        existingUser.setAadhar_img_path(updatedUser.getAadhar_img_path());
        existingUser.setRole_id(updatedUser.getRole_id());

        Users savedUser = usersRepository.save(existingUser);

        System.out.println("User updated successfully with id: " + id);

        return savedUser;
    }



    
    
    
    
    
}



      

