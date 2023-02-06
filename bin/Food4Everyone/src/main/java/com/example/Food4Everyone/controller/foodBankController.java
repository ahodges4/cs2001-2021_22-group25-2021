package com.example.Food4Everyone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Food4Everyone.model.*;
import com.example.Food4Everyone.repository.*;
@RestController
public class foodBankController {
	public long time = 0;
	public ArrayList<foodBank> allFoodBanks = new ArrayList<>(); //FoodBank Cache


	@Autowired
	private FoodBankRepository foodBankRepository;
	
	@Autowired
	private CharityRepository charityRepository;
	
	@Autowired
	private PoliticsRepository politicsRepository;
	
	@Autowired
	private UrlsRepository urlsRepository;

	@Autowired
	private LocationsRepository locationsRepository;
	
	//Get all FoodBanks
	@GetMapping("/foodBanks")
	@CrossOrigin
	public List<foodBank> getAllFoodBanks(){
		if (time == 0) {
			time = System.currentTimeMillis();
			foodBankRepository.findAll().forEach(allFoodBanks::add);
		}

		long currTime = System.currentTimeMillis();
		
		//Every 15 mins update Cache
		if (currTime - time > 900000){
			allFoodBanks.clear();
			time = System.currentTimeMillis();
			foodBankRepository.findAll().forEach(allFoodBanks::add);
		}
		return (List<foodBank>) allFoodBanks;
	}

	@GetMapping("/foodBanks/ID")
	@CrossOrigin
	public foodBank getFoodBankByID(@RequestParam int foodBankID){
		return foodBankRepository.findById(foodBankID);
	}

	@GetMapping("/foodBanks/locations")
	@CrossOrigin
	public List<Locations> getAllLocations(){
		return (List<Locations>) locationsRepository.findAll();
	}


	//Get all Charities
	@GetMapping("/charities")
	@CrossOrigin
	public List<Charity> getAllCharities(){
		return (List<Charity>) charityRepository.findAll();
	}

	//Get all Politics
	@GetMapping("/politics")
	@CrossOrigin
	public List<Politics> getAllPolitics(){
		return (List<Politics>) politicsRepository.findAll();
	}

	//Get all Urls
	@GetMapping("/urls")
	@CrossOrigin
	public List<Urls> getAllUrls(){
		return (List<Urls>) urlsRepository.findAll();
	}
}
