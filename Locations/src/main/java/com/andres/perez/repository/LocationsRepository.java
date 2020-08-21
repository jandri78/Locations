package com.andres.perez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.perez.model.Locations;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, Integer> {

}
