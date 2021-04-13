package tp.spring.boot.piedvdari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Assurance;
import tp.spring.boot.piedvdari.repositories.AssurancesRepository;

@Service

public class AssurancesService implements IAssurancesService {
	@Autowired
	 AssurancesRepository assurep;
	@Override
	public void ajouterAssurance(Assurance assurance)
	{
		assurep.save(assurance);
	}
	public void supprimerAssurance(Assurance assurance){
		
		assurep.delete(assurance);
	}
	public Assurance modiferAssurance(Assurance assurance ){
		return assurep.save(assurance);
	}
}