package com.example.Food4Everyone.model;

import com.google.gson.annotations.SerializedName;

public class foodBankFull {
	
	@SerializedName("name") //Name of the food bank
	public String name;
	
	@SerializedName("alt_name") //Alternative name, for example in Welsh
	public String alt_name;
	
	
	@SerializedName("address") //Address of the food bank
	public String address;
	
	
	@SerializedName("closed") //Is the food bank closed
	public boolean closed;
	
	
	@SerializedName("country") //Country, or Crown dependency, that the food bank's main location is in
	public String country;
	
	
	@SerializedName("created") //Date and time of when the food bank was added to the API
	public String created;
	
	
	@SerializedName("email") //Email of the food bank
	public String email;
	
	
	@SerializedName("lat_lng") //Comma separated latitude and longitude
	public String lat_lng;
	
	
	@SerializedName("network") //Name of the food bank network the food bank is in, or "Independent"
	public String network;
	
	@SerializedName("phone") //Phone number of the food bank
	public String phone;
	
	@SerializedName("secondary_phone") //Secondary phone number of the food bank
	public String secondary_phone;
	
	@SerializedName("postcode") //Post code of the food bank
	public String postcode;
	
	@SerializedName("slug") //Slugified name of the food bank
	public String slug;
	
	public Charity charity;
	
	public Politics politics;
	
	public Urls urls;
	
	public class Charity{
		
		public int charityID;
		
		@SerializedName("registration_id") //Charity number of the registered charity that the food bank operates under
		public String registration_id;
		
		@SerializedName("register_url") //URL of the charity entry with the local registrar
		public String register_url;
	}
	
	public class Politics{
		
		public int politicsID;
		
		@SerializedName("parliamentary_constituency")
		public String parliamentary_constituency;
		
		@SerializedName("mp")
		public String mp;
		
		@SerializedName("mp_party")
		public String mp_party;
		
		@SerializedName("ward")
		public String ward;
		
		@SerializedName("district")
		public String district;
	}
	
	public class Urls{
		
		public int urlID;
		
		@SerializedName("homepage") //Homepage of the food bank
		public String homepage;
		
		@SerializedName("html") //API HTML URL of the food bank
		public String html;
		
		@SerializedName("self") //API URL of the food bank
		public String self;
		
		@SerializedName("shopping_list") //URL of the shopping list of what a food bank requires
		public String shopping_list;
	}
}
