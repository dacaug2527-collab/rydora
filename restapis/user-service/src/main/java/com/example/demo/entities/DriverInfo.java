package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "driver_info")
public class DriverInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Integer driverId;
    
    @Column(name = "driving_license")
    private String drivingLicense;
    
    @Column(name = "driving_license_path")
    private String drivingLicensePath;
    
    @Column(name = "pan_card")
    private String panCard;
    
    @Column(name = "account_no")
    private String accountNo;
    

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;
    
    @Column(name = "driver_status")
    Boolean driverStatus;
    
    
    
}

