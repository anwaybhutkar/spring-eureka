package com.mseureka.poc.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Configuration to enable zuul proxy along with eureka server.
 * Eureka discovery clients will register to eureka server.
 * All routes initialized in application.yml
 * 
 * @author anway
 *
 */
@EnableZuulProxy
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}
}
