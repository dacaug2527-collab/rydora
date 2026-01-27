package com.example.demo.entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="driver_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer driver_id;
	String driver_license;
	String driver_license_path;
	String pan_card;
	Integer account_no;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	Users user;
	@Enumerated(EnumType.STRING )
	DriverStatus driver_status;
	
}
