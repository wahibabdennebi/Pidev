package tp.spring.boot.piedvdari.entities;

import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class Admin extends User {
	
	
	private int id_admin;
	private String login;
	private String password_admin;
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword_admin() {
		return password_admin;
	}
	public void setPassword_admin(String password_admin) {
		this.password_admin = password_admin;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
