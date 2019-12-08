package com.mseureka.poc.weatherservice.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mseureka.poc.weatherservice.config.OpenWeatherMapProperties;

/**
 * Service to get weather info from open whether map.
 * 
 * @author anway
 *
 */
@Service
public class WeatherService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	OpenWeatherMapProperties weatherProps;

	/**
	 * Fetch weather report from open weather.
	 * 
	 * @param city
	 * @param country
	 * @return
	 */
	public Object getWeather(final String city, final String country) {
		try {
			String url = String.format(weatherProps.getUrl(), city, country, weatherProps.getKey());
			RequestEntity<?> request = RequestEntity.get(new URI(url)).accept(MediaType.APPLICATION_JSON).build();
			ResponseEntity<Object> weatherResponse = restTemplate.exchange(request, Object.class);
			return weatherResponse.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
