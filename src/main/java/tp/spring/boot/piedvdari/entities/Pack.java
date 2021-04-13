package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@SuppressWarnings("serial")
@Entity
public class Pack implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private int id_pack;
	@Enumerated(EnumType.STRING)
	private Type_pack type_pack;
	private int price;
	private String devis;
	
	 static final int durée=-30;
	
	public static int getDurée() {
		return durée;
	}
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	@OneToOne
	private Costumer costumer;
	@OneToMany(mappedBy = "pack")
	private List<Card_Details> listeCard;
	public Pack(int id_pack, Type_pack type_pack, int price, String devis, Date date, Costumer costumer,
			List<Card_Details> listeCard, Assurance assurance) {
		super();
		this.id_pack = id_pack;
		this.type_pack = type_pack;
		this.price = price;
		this.devis = devis;
		this.date = date;
		this.costumer = costumer;
		this.listeCard = listeCard;
		this.assurance = assurance;
	}
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
	@Override
	public String toString() {
		return "Pack [id_pack=" + id_pack + ", type_pack=" + type_pack + ", price=" + price + ", devis=" + devis
				+ ", date=" + date + ", costumer=" + costumer + ", listeCard=" + listeCard + ", assurance=" + assurance
				+ "]";
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


	public Costumer getCostumer() {
		return costumer;
	}
	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}
	public List<Card_Details> getListeCard() {
		return listeCard;
	}
	public void setListeCard(List<Card_Details> listeCard) {
		this.listeCard = listeCard;
	}
	public Assurance getAssurance() {
		return assurance;
	}
	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}
	

}
