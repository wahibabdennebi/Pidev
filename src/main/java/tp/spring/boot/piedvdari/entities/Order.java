package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;



@Table(name="orders") 
@Entity
public class Order implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idOrder;
	private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	private Furniture furniture;
	@ManyToOne
	private Shooping_Card shopping;
	public int getIdOrder() {
		return idOrder;
	}
	public double getPrice() {
		return price;
	}
	public String getCurrency() {
		return currency;
	}
	public String getMethod() {
		return method;
	}
	public String getIntent() {
		return intent;
	}
	public String getDescription() {
		return description;
	}
	public Furniture getFurniture() {
		return furniture;
	}
	public Shooping_Card getShopping() {
		return shopping;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}
	public void setShopping(Shooping_Card shopping) {
		this.shopping = shopping;
	}
	public Order(double price, String currency, String method, String intent, String description) {
		super();
		this.price = price;
		this.currency = currency;
		this.method = method;
		this.intent = intent;
		this.description = description;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
