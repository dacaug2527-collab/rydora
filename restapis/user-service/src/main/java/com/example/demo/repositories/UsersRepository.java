package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	Users findByEmailAndPassword(String email, String password);
	List<Users> findByRoleId(Integer roleId);
	
	@Query("""
			SELECT DISTINCT u
			FROM Users u
			JOIN u.driverInfo d
			LEFT JOIN Booking b 
			    ON b.driver.driverId = d.driverId
			    AND b.startDate <= :endDate
			    AND b.endDate >= :startDate
			WHERE u.roleId = 3
			AND b.bookingId IS NULL
			""")
			List<Users> findAvailableDrivers(
			    @Param("startDate") LocalDate startDate,
			    @Param("endDate") LocalDate endDate
			);
 

}
