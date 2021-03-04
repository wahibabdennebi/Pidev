package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@SuppressWarnings("serial")
@Entity
public class Order implements Serializable {
	@Id
 private int id_order;
	@OneToMany(mappedBy = "order")
	private List<Furniture> listfurniture;
	@OneToOne(mappedBy = "order")
	private Shooping_Card shopping;

	public Order() {
		super();
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}
	
}
