package com.example.Food4Everyone.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.Food4Everyone.model.foodBank;

public interface FoodBankRepository extends CrudRepository<foodBank,Long>{
	//List<foodBank> findByName(String name);
	
	foodBank findById(long foodBankID);
	foodBank findFoodBankByAddress(String address);
}
