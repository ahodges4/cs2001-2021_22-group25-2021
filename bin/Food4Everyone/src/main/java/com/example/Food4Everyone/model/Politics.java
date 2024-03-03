package com.example.Food4Everyone.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "politics")
@EntityListeners(AuditingEntityListener.class)
public class Politics implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "Politics_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@GeneratedValue(generator = "sequence-generator")
	private Long politicsID;

	@NotBlank
	private String parliamentary_constituency;
	
	@NotBlank
	private String mp;
	
	@NotBlank
	private String mp_party;
	
	@NotBlank
	private String ward;
	
	@NotBlank
	@Column(unique=true)
	private String district;
	
	
	public Politics(@NotBlank String parliamentary_constituency, @NotBlank String mp, @NotBlank String mp_party, @NotBlank String ward, @NotBlank String district ) {
		super();
		this.parliamentary_constituency = parliamentary_constituency;
		this.mp = mp;
		this.mp_party = mp_party;
		this.ward = ward;
		this.district = district;
	}
	
	public Politics() {
		super();
	}

	public Long getPoliticsID(){
		return this.politicsID;
	}

	public void setPoliticsID(Long politicsID){
		this.politicsID = politicsID;
	}
	
	public String getParliamentary_constituency() {
		return parliamentary_constituency;
	}
	
	public void setParliamentary_constiturncy(String parliamentary_constituency ) {
		this.parliamentary_constituency = parliamentary_constituency;
	}
	
	public String getMp() {
		return mp;
	}
	
	public void setMp(String mp) {
		this.mp = mp;
	}
	
	public String getMp_party() {
		return mp_party;
	}

	public void setMp_party(String mp_party) {
		this.mp_party = mp_party;
	}
	
	public String getWard() {
		return ward;
	}
	
	public void setWard(String ward) {
		this.ward = ward;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
}
