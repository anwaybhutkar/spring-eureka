package com.mseureka.poc.placesservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mseureka.poc.placesservice.repository.entity.Place;


/**
 * Simple place repository.
 * 
 * @author anway
 *
 */
public interface PlaceRepository extends JpaRepository<Place, Long> {

	public List<Place> findAll();
}
