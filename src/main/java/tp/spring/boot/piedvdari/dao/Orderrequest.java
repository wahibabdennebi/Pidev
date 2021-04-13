package tp.spring.boot.piedvdari.dao;

import tp.spring.boot.piedvdari.entities.User;

public class Orderrequest {
	private User user;

	public Orderrequest(User user) {
		super();
		this.user = user;
	}
	public Orderrequest() {
		super();
		
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orderrequest [user=" + user + "]";
	}
	

}
