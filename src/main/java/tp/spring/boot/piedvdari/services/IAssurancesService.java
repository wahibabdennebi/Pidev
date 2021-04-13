package tp.spring.boot.piedvdari.services;

import tp.spring.boot.piedvdari.entities.Assurance;

public interface IAssurancesService {

	void ajouterAssurance(Assurance assurance);

	void supprimerAssurance(Assurance assurance);

	Assurance modiferAssurance(Assurance assurance);

}
