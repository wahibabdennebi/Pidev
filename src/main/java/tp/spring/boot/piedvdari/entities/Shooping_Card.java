package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@SuppressWarnings("serial")
@Entity
public class Shooping_Card implements Serializable {
	@Id
	private int id_card;
	private int total_card;
	private int total_price;
	
	
	public Shooping_Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_card() {
		return id_card;
	}
	public void setId_card(int id_card) {
		this.id_card = id_card;
	}
	public int getTotal_card() {
		return total_card;
	}
	public void setTotal_card(int total_card) {
		this.total_card = total_card;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}
