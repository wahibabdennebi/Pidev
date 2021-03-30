package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
public class Claim implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_Claim;
	private String description;
	@ManyToOne
	@JsonBackReference
	private Costumer costumer;
	
	@ManyToOne
	@JsonBackReference
	private Ads ads;
	
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_Claim() {
		return id_Claim;
	}
	public void setId_Claim(int id_Claim) {
		this.id_Claim = id_Claim;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Costumer getCostumer() {
		return costumer;
	}
	public Ads getAds() {
		return ads;
	}
	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}
	public void setAds(Ads ads) {
		this.ads = ads;
	}
	public Claim(String description, Costumer costumer, Ads ads) {
		super();
		this.description = description;
		this.costumer = costumer;
		this.ads = ads;
	}
	
	
	

}
