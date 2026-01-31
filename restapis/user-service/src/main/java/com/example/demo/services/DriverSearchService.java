package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class DriverSearchService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> searchAvailableDrivers(LocalDate startDate, LocalDate endDate) {
        return usersRepository.findAvailableDrivers(startDate, endDate);
    }
}

