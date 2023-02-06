package com.example.Food4Everyone.model;

import java.io.Serializable;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="charities")
@EntityListeners(AuditingEntityListener.class)
public class Charity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "Charity_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@GeneratedValue(generator = "sequence-generator")
	@Column(name = "charityID")
	private Long charityID; //Primary Key

	@NotBlank
	@Column(unique=true)
	private String registration_id; 
	
	@NotBlank
	private String register_url;
	
	//Constructor
	public Charity(@NotBlank String registration_id, @NotBlank String register_url) {
		super();
		this.registration_id = registration_id;
		this.register_url = register_url;
		
	}
	
	public Charity() {
		super();
	}
	
	//Getters and Setters
	public Long getCharityID(){
		return this.charityID;
	}

	public void setCharityID(Long charityID){
		this.charityID = charityID;
	}
	
	public String getRegistration_id() {
		return registration_id;
	}
	
	public void setRegistration_id(String id) {
		this.registration_id = id;
	}
	
	public String getRegister_url() {
		return register_url;
	}
	
	public void setRegister_url(String url) {
		this.register_url = url;
	}
}
