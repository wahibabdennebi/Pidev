package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Ads implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_ad;
	private String title;
	private	String description;
	private int price;
	private String adress;
	private int area;
	private int room ;
	@Temporal(TemporalType.DATE)
	private Date creationdate;
	private String type_ads;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Enumerated(EnumType.STRING)
	private City city;
	@ManyToOne
	private User user;
	public int getId_ad() {
		return id_ad;
	}
	public void setId_ad(int id_ad) {
		this.id_ad = id_ad;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	
	
	
	public String getType_ads() {
		return type_ads;
	}
	public void setType_ads(String type_ads) {
		this.type_ads = type_ads;
	}
	public Ads() {
		super();
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	
	

}
