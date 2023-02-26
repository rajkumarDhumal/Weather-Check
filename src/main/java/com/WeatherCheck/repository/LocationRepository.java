package com.WeatherCheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WeatherCheck.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

	Location findByPincode(String pincode);

}
