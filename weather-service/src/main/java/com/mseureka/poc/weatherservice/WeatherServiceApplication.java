package com.mseureka.poc.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Eureka client/discovery for weather service.
 * Configuration to register eureka client to zone specified in application.yml
 * 
 * @author anway
 *
 */
@EnableEurekaClient
@EnableConfigurationProperties
@SpringBootApplication
public class WeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}
}
