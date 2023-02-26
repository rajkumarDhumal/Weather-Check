package com.WeatherCheck.model;

import java.time.LocalDate;

public class WeatherRequest {
	
	private String pincode;
	
	private LocalDate date;

	public WeatherRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WeatherRequest(String pincode, LocalDate date) {
		super();
		this.pincode = pincode;
		this.date = date;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
