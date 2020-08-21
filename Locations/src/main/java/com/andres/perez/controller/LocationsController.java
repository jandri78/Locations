package com.andres.perez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.perez.model.Locations;
import com.andres.perez.service.LocationsService;

@RestController
@RequestMapping("/getlocation")
public class LocationsController {

	@Autowired
	private LocationsService locationsService;

	@GetMapping
	public ResponseEntity<List<Locations>> get() {

		List<Locations> result = locationsService.get();

		return new ResponseEntity<List<Locations>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Locations> getById(@PathVariable(value = "id") int id) {

		Optional<Locations> result = locationsService.getById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Locations>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Locations>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	public Locations post(@RequestBody Locations location) {
		return locationsService.post(location);
	}

	@PutMapping
	public Locations put(@RequestBody Locations location) throws Exception {
		return locationsService.put(location);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Locations> delete(@PathVariable(value = "id") int id) {

		Optional<Locations> result = locationsService.delete(id);

		if (result.isPresent()) {
			return new ResponseEntity<Locations>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Locations>(HttpStatus.NOT_FOUND);
		}
	}

}
