package tp.spring.boot.piedvdari.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
@Entity
@Eager
public class Costumer extends User {

	private int id_client;
	private String login_client;
	private String password_client;
	private int point_fid;
	@OneToOne(mappedBy = "costumer")
	private Pack pack;
	@ManyToMany(mappedBy = "listCostumer")
	private List<Visit> listevisit;
	@OneToMany(mappedBy = "costumer")
	private List<Borrower> listBorrow;
	@OneToMany(mappedBy = "costumer")//fetch = FetchType.EAGER)
	private List<Claim>  listclaim;
	
	@OneToMany(mappedBy = "costumer",fetch = FetchType.EAGER)
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
	public int getPoint_fid() {
		return point_fid;
	}
	public void setPoint_fid(int point_fid) {
		this.point_fid = point_fid;
	}
	public Pack getPack() {
		return pack;
	}
	public List<Visit> getListevisit() {
		return listevisit;
	}
	public List<Borrower> getListBorrow() {
		return listBorrow;
	}
	public List<Claim> getListclaim() {
		return listclaim;
	}
	public List<Furniture> getListfurniture() {
		return listfurniture;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	public void setListevisit(List<Visit> listevisit) {
		this.listevisit = listevisit;
	}
	public void setListBorrow(List<Borrower> listBorrow) {
		this.listBorrow = listBorrow;
	}
	public void setListclaim(List<Claim> listclaim) {
		this.listclaim = listclaim;
	}
	public void setListfurniture(List<Furniture> listfurniture) {
		this.listfurniture = listfurniture;
	}
	

}
