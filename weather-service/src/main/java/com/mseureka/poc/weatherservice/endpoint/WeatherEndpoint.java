package com.mseureka.poc.weatherservice.endpoint;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mseureka.poc.weatherservice.service.WeatherService;

/**
 * Weather service endpoint for handling all weather APIs.
 * 
 * @author anway
 *
 */
@RestController
public class WeatherEndpoint {

	@Autowired
	WeatherService weatherService;

	/**
	 * Endpoint to get temperature of city.
	 * 
	 * @param city
	 * @param country
	 * @return
	 * @throws URISyntaxException
	 */
	@GetMapping("/{city}/{country}")
	public ResponseEntity<?> getTemperature(@PathVariable("city") final String city,
			@PathVariable("country") final String country) {
		return new ResponseEntity<>(weatherService.getWeather(city, country), HttpStatus.OK);
	}

}
