package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Car;


public interface CarRepository extends JpaRepository<Car,Long> {
	
	 @Query("SELECT c FROM Car c WHERE YEAR(c.deliveryDate) = :year")
	    List<Car> findByDeliveryDateYear(@Param("year") int year);
	 
		
	 @Query("SELECT COUNT(c) FROM Car c WHERE YEAR(c.deliveryDate) = :year")
	    int CountByDeliveryDateYear(@Param("year") int year);
}
