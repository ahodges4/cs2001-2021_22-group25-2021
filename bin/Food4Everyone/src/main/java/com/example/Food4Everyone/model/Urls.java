package com.example.Food4Everyone.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "urls")
@EntityListeners(AuditingEntityListener.class)
public class Urls implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "URLs_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@GeneratedValue(generator = "sequence-generator")
	private int urlID; //Primary Key
	
	@NotBlank
	private String homepage;
	
	@NotBlank
	@Column(unique=true)
	private String html;
	
	@NotBlank
	private String self;
	
	private String shopping_list;
	
	//Constructor
	public Urls(@NotBlank String homepage, @NotBlank String html, @NotBlank String self, @NotBlank String shopping_list) {
		super();
		this.homepage = homepage;
		this.html = html;
		this.self = self;
		this.shopping_list = shopping_list;
	}
	
	public Urls() {
		super();
	}
	
	//Getters and setters
	public int getUrlID(){
		return this.urlID;
	}

	public void setUrlID(int urlID){
		this.urlID = urlID;
	}

	public String getHomepage() {
		return homepage;
	}
	
	public void setHomepage(String homepage ) {
		this.homepage = homepage;
	}
	
	public String getHtml() {
		return html;
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	
	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}
	
	public String getShopping_list() {
		return shopping_list;
	}
	
	public void setshopping_list(String ward) {
		this.shopping_list = ward;
	}


}
