package com.example.Food4Everyone.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Food4Everyone.model.Charity;

public interface CharityRepository extends CrudRepository<Charity,Long>{

	Charity findById(long charityID);
}
