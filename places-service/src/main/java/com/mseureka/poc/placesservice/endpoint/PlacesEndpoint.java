package com.mseureka.poc.placesservice.endpoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mseureka.poc.placesservice.config.WeatherServiceProperties;
import com.mseureka.poc.placesservice.repository.PlaceRepository;
import com.mseureka.poc.placesservice.repository.entity.Place;

/**
 * Places service endpoint, handing all places related API calls.
 * 
 * @author anway
 *
 */
@RestController
public class PlacesEndpoint {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	PlaceRepository placeRepo;
	
	@Autowired
	WeatherServiceProperties weatherProps;

	/**
	 * Endpoint to get all available places in database and fetch temperature of
	 * each place from weather service.
	 * 
	 * @return
	 */
	@GetMapping("/places")
	public Map<String, String> getPlaces() {
		Map<String, String> response = new HashMap<>();

		List<Place> places = placeRepo.findAll();

		if (!CollectionUtils.isEmpty(places)) {
			// Fetch temperature of each place from weather service.
			places.forEach(place -> {
				try {
					ResponseEntity<String> weatherResponse = restTemplate.exchange(
							weatherProps.getUrl() + place.getCity() + "/" + place.getCountry(), HttpMethod.GET, null,
							new ParameterizedTypeReference<String>() {});
					response.put(place.getCity(), weatherResponse.getBody());
				} catch (Exception e) {
					e.printStackTrace();
					response.put(place.getCity(), "Weather not available");
				}
			});
		}
		return response;

	}
}
