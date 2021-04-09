package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Bank implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_bank;
	private String name;
	private float taux_int;
	private float tmm;
	private String mail;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public float getTmm() {
		return tmm;
	}
	public void setTmm(float tmm) {
		this.tmm = tmm;
	}
	//public List<Borrower> getListBorrower() {
	//	return listBorrower;
	//}
	//public void setListBorrower(List<Borrower> listBorrower) {
	//	this.listBorrower = listBorrower;
	//}

	@Temporal(TemporalType.DATE)
	private  Date date_tmm;
	public Date getDate_tmm() {
		return date_tmm;
	}
	public void setDate_tmm(Date date_tmm) {
		this.date_tmm = date_tmm;
	}

	public float getTaux_int() {
		return taux_int;
	}
	public void setTaux_int(float taux_int) {
		this.taux_int = taux_int;
	}

	@OneToMany(mappedBy = "bank")
	private List<Borrower> listBorrower;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_bank() {
		return id_bank;
	}
	public void setId_bank(int id_bank) {
		this.id_bank = id_bank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
