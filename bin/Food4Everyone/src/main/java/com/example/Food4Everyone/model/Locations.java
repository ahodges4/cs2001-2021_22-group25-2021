package com.example.Food4Everyone.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Locations {
    @Id
    private Long foodBankID;

    private float lat;

	private float lng;

    public Locations(){
        super();
    }
    public Locations(Long foodBankID, float lat, float lng){
        super();
        this.foodBankID = foodBankID;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getFoodBankID(){
        return this.foodBankID;
    }
    public float getLat(){
        return this.lat;
    }
    public float getLng(){
        return this.lng;
    }
}
