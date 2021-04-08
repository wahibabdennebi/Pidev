package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import java.util.Date;
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
import com.fasterxml.jackson.annotation.JsonFormat;


@SuppressWarnings("serial")
@Entity
public class Ads implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_ad;
	private String title;
	private	String description;
	private int price;
	private String adress;
	private int area;
	private int room ;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationdate;
	@Enumerated(EnumType.STRING)
	private Type_ads type_ads;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Enumerated(EnumType.STRING)
	private City city;
	@ManyToOne
	@JoinColumn(name="user_id" )
	private User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="ad", fetch=FetchType.LAZY)
	private List<Favorite_Ads> listeFavorite;
	
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
	
	
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
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
	

	
	public Ads(int id_ad, String title, String description, int price, String adress, int area, int room,
			Date creationdate, Type_ads type_ads, Category category, City city, User user) {
		super();
		this.id_ad = id_ad;
		this.title = title;
		this.description = description;
		this.price = price;
		this.adress = adress;
		this.area = area;
		this.room = room;
		this.creationdate = creationdate;
		this.type_ads = type_ads;
		this.category = category;
		this.city = city;
		this.user = user;
	}
	public Type_ads getType_ads() {
		return type_ads;
	}
	public void setType_ads(Type_ads type_ads) {
		this.type_ads = type_ads;
	}
	@JsonBackReference
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public Ads(int id_ad, String title, String description, int price, String adress, int area, int room,
			Date creationdate, Type_ads type_ads, Category category, City city, User user,
			List<Favorite_Ads> listeFavorite) {
		super();
		this.id_ad = id_ad;
		this.title = title;
		this.description = description;
		this.price = price;
		this.adress = adress;
		this.area = area;
		this.room = room;
		this.creationdate = creationdate;
		this.type_ads = type_ads;
		this.category = category;
		this.city = city;
		this.user = user;
		this.listeFavorite = listeFavorite;
	}
	
	

	
	

}
