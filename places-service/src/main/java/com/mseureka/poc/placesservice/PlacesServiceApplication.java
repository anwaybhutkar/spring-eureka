package com.mseureka.poc.placesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Eureka client/discovery for places service.
 * Configuration to register eureka client to zone specified in application.yml
 * 
 * @author anway
 *
 */
@EnableEurekaClient
@EnableConfigurationProperties
@SpringBootApplication
public class PlacesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacesServiceApplication.class, args);
	}
}
