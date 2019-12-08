package com.mseureka.poc.placesservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author anway
 *
 */
@Configuration
@ConfigurationProperties(prefix = "weather.service")
public class WeatherServiceProperties {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
