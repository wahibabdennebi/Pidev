package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
public class Card_Details implements Serializable  {
	@Id
	int id_card_details;
	int security_code;
	int postal_code;
	@Temporal(TemporalType.DATE)
	Date expiry_date;
	@ManyToOne
	private Pack pack;
	public int getId_card_details() {
		return id_card_details;
	}
	public void setId_card_details(int id_card_details) {
		this.id_card_details = id_card_details;
	}
	public int getSecurity_code() {
		return security_code;
	}
	public void setSecurity_code(int security_code) {
		this.security_code = security_code;
	}
	public int getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public Card_Details() {
		super();
	}
	

}
