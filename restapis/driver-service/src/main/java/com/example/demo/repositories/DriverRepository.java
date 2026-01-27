package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.DriverInfo;
import com.example.demo.entities.DriverStatus;

@Repository
public interface DriverRepository extends JpaRepository<DriverInfo, Integer> {

	@Query("select d from DriverInfo d where d.driver_status = ?1")
    public List<DriverInfo> availableDriver(DriverStatus AVAILABLE);

	
}
