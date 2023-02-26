package com.WeatherCheck.service;

import java.time.LocalDate;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.WeatherCheck.model.Location;
import com.WeatherCheck.model.OpencageResponse;
import com.WeatherCheck.model.OpenweatherResponse;
import com.WeatherCheck.model.WeatherData;
import com.WeatherCheck.repository.LocationRepository;
import com.WeatherCheck.repository.WeatherDataRepository;

@Service
public class WeatherServiceImpl {
	
	
    @Autowired
    private WeatherDataRepository weatherDataRepository;
    
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    String OPENCAGE_API_KEY = "7c9603d21a554a2d8fd97489dcc0a4ca";
    String OPENWEATHER_API_KEY = "0c6f9139899cde8ccd1ba9408762e114";
    
    
    private static final String OPENCAGE_API_URL = "https://api.opencagedata.com/geocode/v1/json?q=%s&key=%s";
    private static final String OPENWEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&dt=%d&appid=%s&units=metric";
    

    
    public WeatherData getData(String pincode, LocalDate date) {
    	
    	
    	if (checkDataPincode(pincode) != null) {
			
    		Location location = checkDataPincode(pincode);
			
    		OpenweatherResponse openweatherResponse = getWeatherData(location.getLatitude(), location.getLongitude(), date);
			
			WeatherData weatherData = new WeatherData();
			
			weatherData.setDate(date);
			weatherData.setTemperature(openweatherResponse.getMain().getTemp());
			weatherData.setHumidity(openweatherResponse.getMain().getHumidity());
			weatherData.setPressure(openweatherResponse.getMain().getPressure());
			
        	
        	return weatherData;
    	}
    	
    	else {
    		
    		
    		OpencageResponse opencageResponse = getLatLong(pincode);
        	
        	double latitude = opencageResponse.getResults()[0].getGeometry().getLat();
            double longitude = opencageResponse.getResults()[0].getGeometry().getLng();
            
        	OpenweatherResponse openweatherResponse = getWeatherData(latitude, longitude, date);
        	
        	WeatherData weatherData = new WeatherData();
        	
        	weatherData.setDate(date);
        	weatherData.setTemperature(openweatherResponse.getMain().getTemp());
        	weatherData.setHumidity(openweatherResponse.getMain().getHumidity());
        	weatherData.setPressure(openweatherResponse.getMain().getPressure());
        	
        	Location location = new Location();
        	
        	location.setPincode(pincode);
        	location.setLatitude(opencageResponse.getResults()[0].getGeometry().getLat());
        	location.setLongitude(opencageResponse.getResults()[0].getGeometry().getLng());
        	
        	weatherDataRepository.save(weatherData);
        	locationRepository.save(location);
        	
        	return weatherData;
		}
    	
    	
    }
    
    private OpencageResponse getLatLong(String pincode) {
    	
    	String opencageUrl = String.format(OPENCAGE_API_URL, pincode, OPENCAGE_API_KEY);
        OpencageResponse opencageResponse = restTemplate.getForObject(opencageUrl, OpencageResponse.class);
        
        return opencageResponse;
        
    }
    
    public OpenweatherResponse getWeatherData(double latitude, double longitude, LocalDate date) {

    	
    	long unixTimestamp = date.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
        String openweatherUrl = String.format(OPENWEATHER_API_URL, latitude, longitude, unixTimestamp, OPENWEATHER_API_KEY);
        OpenweatherResponse openweatherResponse = restTemplate.getForObject(openweatherUrl, OpenweatherResponse.class);

        return openweatherResponse;
    }
    

    public Location checkDataPincode(String pincode) {
    	
    	Location location = locationRepository.findByPincode( pincode);
		return location;
    	
    	
    }
    
    
}
