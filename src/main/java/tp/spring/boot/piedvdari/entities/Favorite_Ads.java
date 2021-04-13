package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Favorite_Ads implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_favorite;
	@ManyToOne
	@JoinColumn(name="user_id" )
	private User user;
	@ManyToOne
	@JoinColumn(name="Ad_id" )
	private Ads ad;
	
	@Temporal(TemporalType.DATE)
	private Date fav_ad_date = new Date (System.currentTimeMillis());
	
	private  boolean states = true ;
	
	


	public boolean isStates() {
		return states;
	}

	public void setStates(boolean states) {
		this.states = states;
	}

	public Favorite_Ads(int id_favorite, User user, Ads ad, Date fav_ad_date, boolean states) {
		super();
		this.id_favorite = id_favorite;
		this.user = user;
		this.ad = ad;
		this.fav_ad_date = fav_ad_date;
		this.states = states;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ads getAd() {
		return ad;
	}

	public void setAd(Ads ad) {
		this.ad = ad;
	}

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

	public Favorite_Ads(int id_favorite, User user, Ads ad) {
		super();
		this.id_favorite = id_favorite;
		this.user = user;
		this.ad = ad;
	}
	public Favorite_Ads(int id_favorite, User user, Ads ad, Date fav_ad_date) {
		super();
		this.id_favorite = id_favorite;
		this.user = user;
		this.ad = ad;
		this.fav_ad_date = fav_ad_date;
	}

	public Date getFav_ad_date() {
		return fav_ad_date;
	}

	public void setFav_ad_date(Date fav_ad_date) {
		this.fav_ad_date = fav_ad_date;
	}

	@Override
	public String toString() {
		return "Favorite_Ads [id_favorite=" + id_favorite + ", user=" + user + ", ad=" + ad + ", fav_ad_date="
				+ fav_ad_date + "]";
	}
	
	
	

}
