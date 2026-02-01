package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
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

    private String aadhar;

    @Column(name = "aadhar_img_path")
    private String aadharImgPath;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
