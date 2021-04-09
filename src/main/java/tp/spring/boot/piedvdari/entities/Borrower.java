package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Borrower implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_borrower;
	private int salaire;
	@ManyToOne
	private Costumer costumer;
	@ManyToOne
	private Bank bank;
	public Borrower() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_borrower() {
		return id_borrower;
	}
	public void setId_borrower(int id_borrower) {
		this.id_borrower = id_borrower;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
	

}
