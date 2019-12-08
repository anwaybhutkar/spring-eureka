package com.mseureka.poc.placesservice.config;

import java.util.stream.Stream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.mseureka.poc.placesservice.repository.PlaceRepository;
import com.mseureka.poc.placesservice.repository.entity.Place;

/**
 * Configuration of in memory h2 database and rest template bean with client
 * side load balancing.
 * 
 * @author anway
 *
 */
@Configuration
public class Config implements InitializingBean {

	@Autowired
	PlaceRepository placeRepo;

	/**
	 * {@link RestTemplate} bean with client side load balancing.
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * Load in memory database for places.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Stream.of(new Place(1, "Pune", "India"), new Place(2, "Sidney", "Australia"), new Place(3, "Delhi", "India"),
				new Place(4, "Boston", "US"), new Place(5, "Tokyo", "Japan")).forEach(place -> {
					placeRepo.save(place);
				});

	}

}
