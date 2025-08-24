package com.sanjeeban.DriveMart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanjeeban.DriveMart.Entity.Car;

public interface CarRepository extends JpaRepository<Car,Long> {

//		@Query("SELECT c FROM Car c WHERE c.brand = :brand AND c.model = :model")
//	    Car findCarByBrandAndModel(@Param("brand") String brand, @Param("model") String model);
//
//	    @Modifying
//	    @Query("DELETE FROM Car c WHERE c.brand = :brand AND c.model = :model")
//	    int deleteCarByBrandAndModel(@Param("brand") String brand, @Param("model") String model);
	
}
