package com.example.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Payment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "payment_id")
	    private Integer paymentId;

	    
	    private Double amount;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "payment_method", nullable = false)
	    private PaymentMethod paymentMethod;

	    @Column(name = "date_time", nullable = false)
	    private LocalDateTime dateTime;

	    @Column(name = "transaction_id")
	    private String transactionId;

	    @Column(name = "start_km")
	    private Double startKM;
	    
	    @Column(name = "end_km")
	    private Double endKM;
	    
	    @Column(name = "total_km")
	    private Double totalKM;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name = "payment_status", nullable = false)
	    private PaymentStatus paymentStatus;

	    @ManyToOne
	    @JoinColumn(name = "booking_id", nullable = false)
	    private Booking booking;
}
