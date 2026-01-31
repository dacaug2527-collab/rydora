package com.example.demo.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;

    @Column(name = "start_location")
    private String startLocation;

    @Column(name = "end_location")
    private String endLocation;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "booking_datetime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime bookingDateTime;

    @Column(name = "booking_status")
    private String bookingStatus;

    // ✅ FK → user.user_id (column name user_id1)
    @ManyToOne
    @JoinColumn(name = "user_id1", referencedColumnName = "user_id")
    private Users user;

    // ✅ FK → driver_info.driver_id
    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    private DriverInfo driver;
}
