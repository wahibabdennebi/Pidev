package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Claim implements Serializable {
	@Id
	private int id_Claim;
	private String description;
	@ManyToOne
	private Costumer costumer;
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
	

}
