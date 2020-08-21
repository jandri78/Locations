package com.andres.perez.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.perez.model.Locations;
import com.andres.perez.repository.LocationsRepository;

@Service
public class LocationsService {
	
	@Autowired
	private LocationsRepository repository;
	
	public List<Locations> get() {
		return repository.findAll();
	}
	
	public Optional<Locations> getById(int id) {
		return repository.findById(id);
	}
	
	public Locations post(Locations entity) {
		return repository.save(entity);
	}
	
	public Locations put(Locations location) throws Exception
	{
		Optional<Locations> getting = repository.findById(location.getId());
		
		
		if (getting.isPresent()) {
			return repository.save(location);
		}else {
			throw new Exception("Locations not found for updating");
		}
		
	}
	
	public Optional<Locations> delete(int id) {
		
		Optional<Locations> getting = repository.findById(id);
		
		if (getting.isPresent()) {
			repository.deleteById(id);
		}
		
		return getting;
		
	}

}
