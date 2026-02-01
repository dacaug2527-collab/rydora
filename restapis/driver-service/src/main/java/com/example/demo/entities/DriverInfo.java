package com.example.demo.entities;
import jakarta.persistence.CascadeType;
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

@Entity
@Table(name="driver_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_id", nullable = false)
	private Integer driverId;

	@Column(name = "driver_license", nullable = false)
	private String driverLicense;

	@Column(name = "driver_license_path")
	private String driverLicensePath;

	@Column(name = "pan_card")
	private String panCard;

	@Column(name = "account_no")
	private String accountNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users user;

	@Column(name = "driver_status")
	private Boolean driverStatus;

	
}
