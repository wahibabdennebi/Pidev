package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Furniture implements Serializable {
	@Id
	private int furniture_id ;
	private int price;
	private String description;
	@ManyToOne
	private Costumer costumer;
	@ManyToOne
	private Order order;
	public int getFurniture_id() {
		return furniture_id;
	}
	public void setFurniture_id(int furniture_id) {
		this.furniture_id = furniture_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Furniture() {
		super();
	}
	

}
