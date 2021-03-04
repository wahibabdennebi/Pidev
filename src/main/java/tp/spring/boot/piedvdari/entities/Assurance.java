package tp.spring.boot.piedvdari.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Assurance implements Serializable {
@Id
private int id_assurance;
private int durée;
@Enumerated(EnumType.STRING)
private Type_assurance type_assurance;
@OneToOne
private Pack pack;
public int getId_assurance() {
	return id_assurance;
}
public void setId_assurance(int id_assurance) {
	this.id_assurance = id_assurance;
}
public int getDurée() {
	return durée;
}
public void setDurée(int durée) {
	this.durée = durée;
}
public Type_assurance getType_assurance() {
	return type_assurance;
}
public void setType_assurance(Type_assurance type_assurance) {
	this.type_assurance = type_assurance;
}
public Assurance() {
	super();
	// TODO Auto-generated constructor stub
}
}
