package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;




@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id_user;
	private String name;
	private String email;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user", fetch=FetchType.LAZY)
	private List<Ads> listeads ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user", fetch=FetchType.LAZY)
	private List<Favorite_Ads> listeFavorite;
	@OneToMany(mappedBy = "user")
	private List<Notification> listeNotification;
	public User() {
		super();
		
	}

	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public User(int id_user, String name, String email, List<Ads> listeads) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.email = email;
		this.listeads = listeads;
		
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", name=" + name + ", listeads=" + listeads + ", email=" + email + "]";
	}
@JsonManagedReference
	public List<Ads> getListeads() {
		return listeads;
	}

	public void setListeads(List<Ads> listeads) {
		this.listeads = listeads;
	}

	public User(int id_user, String name, String email, List<Ads> listeads, List<Favorite_Ads> listeFavorite,
			List<Notification> listeNotification) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.email = email;
		this.listeads = listeads;
		this.listeFavorite = listeFavorite;
		this.listeNotification = listeNotification;
	}
	
	
	

}
