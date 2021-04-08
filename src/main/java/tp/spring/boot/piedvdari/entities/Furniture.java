package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
public class Furniture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int furniture_id ;
	private Long price;
	private String description;
	private String titre;
	private boolean state= true;	
	@Enumerated(EnumType.STRING)
	private Type type;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name ="id_client")
	private Costumer costumer;
	@JsonIgnore
	@OneToMany(mappedBy = "furniture")
	private List<Order> orders;
	
	@OneToMany(mappedBy="furnitures",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	private List<ImageModel> listImages;
	
	
	public int getFurniture_id() {
		return furniture_id;
	}
	public void setFurniture_id(int furniture_id) {
		this.furniture_id = furniture_id;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	public Costumer getCostumer() {
		return costumer;
	}
	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public List<ImageModel> getListImages() {
		return listImages;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public void setListImages(List<ImageModel> listImages) {
		this.listImages = listImages;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Furniture(int furniture_id, Long price, String description, String titre, boolean state,Type type) {
		super();
		this.furniture_id = furniture_id;
		this.price = price;
		this.description = description;
		this.titre = titre;
		this.state = state;
		this.type = type;
	}
	
	
	
	
	
	
	
	

}
