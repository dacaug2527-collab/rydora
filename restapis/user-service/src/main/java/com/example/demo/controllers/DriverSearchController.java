package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Users;
import com.example.demo.services.DriverSearchService;

@RestController
@RequestMapping("/drivers")
@CrossOrigin("http://localhost:3000")
public class DriverSearchController {

    @Autowired
    private DriverSearchService service;

    @GetMapping("/search")
    public List<Users> searchDrivers(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        LocalDate sDate = LocalDate.parse(startDate);
        LocalDate eDate = LocalDate.parse(endDate);

        return service.searchAvailableDrivers(sDate, eDate);
    }
}


