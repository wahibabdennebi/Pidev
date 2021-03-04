package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
public class Pack implements Serializable {
	@Id
	private int id_pack;
	@Enumerated(EnumType.STRING)
	private Type_pack type_pack;
	private int price;
	private String devis;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne
	private Costumer costumer;
	@OneToMany(mappedBy = "pack")
	private List<Card_Details> listeCard;
	@OneToOne(mappedBy = "pack")
	private Assurance assurance;
	public int getId_pack() {
		return id_pack;
	}
	public Pack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId_pack(int id_pack) {
		this.id_pack = id_pack;
	}
	public Type_pack getType_pack() {
		return type_pack;
	}
	public void setType_pack(Type_pack type_pack) {
		this.type_pack = type_pack;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDevis() {
		return devis;
	}
	public void setDevis(String devis) {
		this.devis = devis;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
