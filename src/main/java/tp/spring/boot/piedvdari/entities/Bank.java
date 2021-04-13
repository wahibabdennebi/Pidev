package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Bank implements Serializable{
	@Id
	private int id_bank;
	private String name;
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
