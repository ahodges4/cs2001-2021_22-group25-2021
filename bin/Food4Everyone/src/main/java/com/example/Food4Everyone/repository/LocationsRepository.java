package com.example.Food4Everyone.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Food4Everyone.model.Locations;

public interface LocationsRepository extends CrudRepository<Locations,Long>{

	Locations findById(long foodBankID);
}
