package com.example.Food4Everyone.model;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "foodBanks")
@EntityListeners(AuditingEntityListener.class)
public class foodBank implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "foodBank_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@GeneratedValue(generator = "sequence-generator")
	@Column(name = "foodBankID")
	private Long foodBankID; //Primary Key
	
	@NotBlank
	private String name;
	
	
	private String alt_name;
	
	@NotBlank
	@Column(unique=true)
	private String address;
	
	
	private boolean closed;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String created;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String lat_lng;

	private float lat;

	private float lng;
	
	
	private String network;
	
	
	private String phone;
	
	
	private String secondary_phone;
	
	@NotBlank
	private String postcode;
	
	@NotBlank
	private String slug;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "charityID")
	private Charity charity; //Foreign Key
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "politicsID")
	private Politics politics; //Foreign Key
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "urlID")
	private Urls urls; //Foreign Key
	
	//constructor
	public foodBank(@NotBlank String name, String alt_name, @NotBlank String address,
			boolean closed, @NotBlank String country,@NotBlank String created,
			@NotBlank String email, @NotBlank String lat_lng, String network,
			@NotBlank String phone, String secondary_phone, @NotBlank String postcode,
			@NotBlank String slug) {
		super();	
		this.name = name;
		this.alt_name = alt_name;
		this.address = address;
		this.closed = closed;
		this.country = country;
		this.created = created;
		this.email = email;
		this.lat_lng = lat_lng;
		this.network = network;
		this.phone = phone;
		this.secondary_phone = secondary_phone;
		this.postcode = postcode;
		this.slug = slug;
	}
	public foodBank() {
		super();
	}

	//Turns Lat_Lng into data that the google maps api can understand
	public void generateLocation() {
		String[] array = getLat_lng().split(",");
		setLat(Float.parseFloat(array[0]));
		setLng(Float.parseFloat(array[1]));
	}
	
	//Getters and Setters
	public long getID() {
		return foodBankID;
	}
	
	public void setID(Long id) {
		this.foodBankID = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAlt_name() {
		return alt_name;
	}
	
	public void setAlt_name(String alt_name) {
		this.alt_name = alt_name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String Address) {
		this.address = Address;
	}
	
	public boolean getClosed() {
		return closed;
	}
	
	public void setClosed(boolean Closed) {
		this.closed = Closed;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String Country) {
		this.country = Country;
	}
	
	public String getCreated() {
		return created;
	}
	
	public void setCreated(String created) {
		this.created = created;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLat_lng() {
		return lat_lng;
	}
	
	public void setLat_lng(String lat_lng) {
		this.lat_lng = lat_lng;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}
	
	public String getNetwork() {
		return network;
	}
	
	public void setNetwork(String network) {
		this.network = network;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSecondary_phone() {
		return secondary_phone;
	}
	
	public void setSecondary_phone(String secondary_phone) {
		this.secondary_phone = secondary_phone;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	
	public Charity getCharity(){
		return charity;
	}
	
	public void setCharity(Charity charity) {
		this.charity = charity;
	}
	
	public Politics getPolitics() {
		return politics;
	}
	
	public void setPolitics(Politics politics) {
		this.politics = politics;
	}
	
	public Urls getUrl() {
		return urls;
	}
	
	public void setUrl(Urls urls) {
		this.urls = urls;
	}
	
}
