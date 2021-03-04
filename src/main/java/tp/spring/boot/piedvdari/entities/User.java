package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_user;
	private String name;
	@OneToMany(mappedBy = "user")
	private List<Ads> listeads;
	@OneToMany(mappedBy = "user")
	private List<Favorite_Ads> listeFavorite;
	@OneToMany(mappedBy = "user")
	private List<Notification> listeNotification;
	public User() {
		super();
		
	}
	private String email;
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

}
