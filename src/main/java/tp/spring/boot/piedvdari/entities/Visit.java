package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Visit implements Serializable{
	@Id
	private int id_visit;
	@Temporal(TemporalType.DATE)
	private Date date_visit;
	private String description_feedback;
	@ManyToMany
	private List<Costumer> listCostumer;
	public Visit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_visit() {
		return id_visit;
	}
	public void setId_visit(int id_visit) {
		this.id_visit = id_visit;
	}
	public Date getDate_visit() {
		return date_visit;
	}
	public void setDate_visit(Date date_visit) {
		this.date_visit = date_visit;
	}
	public String getDescription_feedback() {
		return description_feedback;
	}
	public void setDescription_feedback(String description_feedback) {
		this.description_feedback = description_feedback;
	}
	

}
