package com.WeatherCheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WeatherCheck.model.WeatherRequest;
import com.WeatherCheck.service.WeatherServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDate;

@RestController
@RequestMapping("/")
@Api(value = "Weather API")
public class WeatherController {
	
	@Autowired
	WeatherServiceImpl service;
	
	@PostMapping("/weather")
	@ApiOperation(value = "Get Weather Information", notes = "Insert pincode and date to return Weather information.")
	public String getWeatherData(@RequestBody WeatherRequest weatherRequest) {
		String pincode = weatherRequest.getPincode();
		LocalDate date = weatherRequest.getDate();
		return service.getData(pincode, date).toString();
	}

}
