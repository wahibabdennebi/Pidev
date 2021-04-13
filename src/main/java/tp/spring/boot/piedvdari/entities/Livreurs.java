package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@SuppressWarnings("serial")
@Entity
public class Livreurs implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_livreur;
	private String nom_livreur;
	@Enumerated(EnumType.STRING)
	private City city;
	@OneToOne
	private Furniture furniture;
	@Enumerated(EnumType.STRING)
	private Status status;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getId_livreur() {
		return id_livreur;
	}
	public void setId_livreur(int id_livreur) {
		this.id_livreur = id_livreur;
	}
	public String getNom_livreur() {
		return nom_livreur;
	}
	public void setNom_livreur(String nom_livreur) {
		this.nom_livreur = nom_livreur;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Furniture getFurniture() {
		return furniture;
	}
	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

}
