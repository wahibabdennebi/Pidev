package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Notification implements Serializable {
	@Id
	private int id_notification;
	private String title_notification;
	@ManyToOne
	private User user;
	
	public int getId_notification() {
		return id_notification;
	}

	public void setId_notification(int id_notification) {
		this.id_notification = id_notification;
	}

	public String getTitle_notification() {
		return title_notification;
	}

	public void setTitle_notification(String title_notification) {
		this.title_notification = title_notification;
	}

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

}
