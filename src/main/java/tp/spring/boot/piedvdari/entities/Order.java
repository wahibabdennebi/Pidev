package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Table(name="orders") 
@Entity
public class Order implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idOrder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Furniture furniture;
	@ManyToOne
	private Shooping_Card shopping;
	public int getIdOrder() {
		return idOrder;
	}
	public Order(int idOrder, Furniture furniture, Shooping_Card shopping) {
		super();
		this.idOrder = idOrder;
		this.furniture = furniture;
		this.shopping = shopping;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Furniture getFurniture() {
		return furniture;
	}
	public Shooping_Card getShopping() {
		return shopping;
	}
	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}
	public void setShopping(Shooping_Card shopping) {
		this.shopping = shopping;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	
	

	
	
	
	
}
