package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Favorite_Ads implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_favorite;
	@ManyToOne
	private User user;

	public int getId_favorite() {
		return id_favorite;
	}

	public void setId_favorite(int id_favorite) {
		this.id_favorite = id_favorite;
	}

	public Favorite_Ads() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
