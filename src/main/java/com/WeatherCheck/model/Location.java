package com.WeatherCheck.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Location {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pincode;
    double latitude;
    double longitude;
    
    @OneToMany
    List<WeatherData> weatherDatas;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(Long id, String pincode, double latitude, double longitude, List<WeatherData> weatherDatas) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.weatherDatas = weatherDatas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<WeatherData> getWeatherDatas() {
		return weatherDatas;
	}

	public void setWeatherDatas(List<WeatherData> weatherDatas) {
		this.weatherDatas = weatherDatas;
	}
    
    
}
