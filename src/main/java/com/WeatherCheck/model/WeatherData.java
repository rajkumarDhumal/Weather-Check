package com.WeatherCheck.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private Double temperature;
    private Double humidity;
    private double pressure;
    
    @ManyToOne
    private Location location;
    
	public WeatherData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeatherData(Long id, LocalDate date, Double temperature, Double humidity, double pressure) {
		super();
		this.id = id;
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	@Override
	public String toString() {
		return "WeatherData : \n date= " + date + "\n, temperature= "+ temperature+ " Celsius \n"+ ", humidity= " + humidity +" % \n"+ ", pressure= "
				+ pressure +" hPa \n";
	}
	

    
	
    
    
    
}