package tp.spring.boot.piedvdari.entities;


import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id ;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date datedebut;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date datefin;
	int value;
	Type type;
	@JsonIgnore
	@ManyToOne
	private Admin admins;
	public int getId() {
		return id;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public int getValue() {
		return value;
	}
	public Type getType() {
		return type;
	}
	public Admin getAdmins() {
		return admins;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public void setAdmins(Admin admins) {
		this.admins = admins;
	}
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Promotion(Date datedebut, Date datefin, int value, Type type, Admin admins) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.value = value;
		this.type = type;
		this.admins = admins;
	}

	
	
	
}
