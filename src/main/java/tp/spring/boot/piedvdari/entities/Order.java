package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 private int id_ordere;
	private String naaame ;

	@ManyToOne
	private  Furniture furniture ;
	@ManyToOne
	private Shooping_Card shopping;

	public Order() {
		super();
	}

	public String getNaaame() {
		return naaame;
	}

	public void setNaaame(String naaame) {
		this.naaame = naaame;
	}


}
