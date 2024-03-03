package com.example.Food4Everyone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Food4Everyone.controller.foodBankController;
import com.example.Food4Everyone.model.*;
import com.example.Food4Everyone.repository.*;
import com.google.gson.Gson;

@Component
public class DBRunner implements CommandLineRunner {
	@Autowired
	private FoodBankRepository foodBankRepository;
	
	@Autowired
	private CharityRepository charityRepository;
	
	@Autowired
	private PoliticsRepository politicsRepository;
	
	@Autowired
	private UrlsRepository urlsRepository;

	@Autowired LocationsRepository locationsRepository;

	
	@Override
	public void run(String... args) throws Exception{
		boolean running = true;
		while (running){
			Scanner myScanner = new Scanner(System.in);
			System.out.println("\nPlease enter the number of the option you want to pick\n1. Build Database (~15mins)\n2. Update Database\n3. Use existing Database");
			String choice = myScanner.nextLine();

			try{
				int Ichoice = Integer.parseInt(choice);
				if (Ichoice == 1 || Ichoice == 2){
					running = false;
					if (Ichoice == 1){
						foodBankRepository.deleteAll();
						charityRepository.deleteAll();
						politicsRepository.deleteAll();
						urlsRepository.deleteAll();
						locationsRepository.deleteAll();
					}
					

					String sURL = "https://www.givefood.org.uk/api/2/foodbanks/"; 
					String data = "";
					BufferedReader reader = null;
					//Fetch JSON data from GiveFood API
					try {
						URL url = new URL(sURL);
						reader = new BufferedReader(new InputStreamReader(url.openStream()));
						StringBuffer buffer = new StringBuffer();
						int read;
						char[] chars = new char[1024];
						while ((read = reader.read(chars)) != -1) {
							buffer.append(chars, 0, read);
						}	
						 data = buffer.toString();	
					} 
					finally {
						if (reader != null) {
							reader.close();
						}
					}	
					Gson gson = new Gson();
					//Convert JSON data into Java Objects 
					foodBankFull[] foodBankFullArray = gson.fromJson(data, foodBankFull[].class);




					for (int i = 0; i < foodBankFullArray.length; i++ ) {
						try{
							foodBank foodbank = new foodBank(
								foodBankFullArray[i].name,
								foodBankFullArray[i].alt_name,
								foodBankFullArray[i].address.replaceAll("\\ufeff", "").replaceAll("\u200b", ""),
								foodBankFullArray[i].closed,
								foodBankFullArray[i].country,
								foodBankFullArray[i].created,
								foodBankFullArray[i].email.replaceAll("\\ufeff", ""),
								foodBankFullArray[i].lat_lng,
								foodBankFullArray[i].network,
								foodBankFullArray[i].phone,
								foodBankFullArray[i].secondary_phone,
								foodBankFullArray[i].postcode,
								foodBankFullArray[i].slug);


							if (foodBankFullArray[i].charity.registration_id != null && foodBankFullArray[i].charity.register_url != null) {
								Charity charity = new Charity(
									foodBankFullArray[i].charity.registration_id,
									foodBankFullArray[i].charity.register_url);
									foodbank.setCharity(charity);

							
							}

						
							if (foodBankFullArray[i].politics.parliamentary_constituency != null && foodBankFullArray[i].politics.mp != null && foodBankFullArray[i].politics.mp_party != null && foodBankFullArray[i].politics.ward != null && foodBankFullArray[i].politics.district != null ) {
								Politics politics = new Politics(
									foodBankFullArray[i].politics.parliamentary_constituency,
									foodBankFullArray[i].politics.mp,
									foodBankFullArray[i].politics.mp_party,
									foodBankFullArray[i].politics.ward,
									foodBankFullArray[i].politics.district);
									foodbank.setPolitics(politics);
							}
						
						
							if (foodBankFullArray[i].urls.homepage != null && foodBankFullArray[i].urls.html != null && foodBankFullArray[i].urls.self != null) {
								Urls urls = new Urls(
									foodBankFullArray[i].urls.homepage, 
									foodBankFullArray[i].urls.html, 
									foodBankFullArray[i].urls.self, 
									foodBankFullArray[i].urls.shopping_list);
									foodbank.setUrl(urls);
							}

							foodbank.generateLocation();
							foodBank EfoodBank = foodBankRepository.findFoodBankByAddress(foodbank.getAddress());
							if (EfoodBank == null){
								foodBankRepository.save(foodbank);
							}
							System.out.println((i + 1) + "/" + foodBankFullArray.length); //Progress Meter
						}catch(Exception e){
							System.out.println(e);
							continue;
						}
					
					}
						
					Iterable<foodBank> foodbanks = foodBankRepository.findAll();

					for(foodBank foodbank : foodbanks){
						Locations location = new Locations(foodbank.getID(),foodbank.getLat(),foodbank.getLng());
						if(locationsRepository.findById(foodbank.getID()) == null){
							locationsRepository.save(location);
						}
						
					}



					System.out.println("Database Built");

				}else if(Ichoice == 3){
					
					running = false;
				}else{
					System.out.println("Invalid Input");
				}

						
				}catch (Exception e){
					System.out.println("Invalid Input" + e);
				}
			}
			
			

		
		


















		

		



		

	}
	
}
