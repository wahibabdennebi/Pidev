package tp.spring.boot.piedvdari.entities;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Costumer extends User {

	private int id_client;
	private String login_client;
	private String password_client;
	@OneToOne(mappedBy = "costumer")
	private Pack pack;
	@ManyToMany(mappedBy = "listCostumer")
	private List<Visit> listevisit;
	@OneToMany(mappedBy = "costumer")
	private List<Borrower> listBorrow;
	@OneToMany(mappedBy = "costumer")
	private List<Claim>  listclaim;
	@OneToMany(mappedBy = "costumer")
	private List<Furniture> listfurniture;
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getLogin_client() {
		return login_client;
	}
	public void setLogin_client(String login_client) {
		this.login_client = login_client;
	}
	public String getPassword_client() {
		return password_client;
	}
	public void setPassword_client(String password_client) {
		this.password_client = password_client;
	}
	public Costumer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
