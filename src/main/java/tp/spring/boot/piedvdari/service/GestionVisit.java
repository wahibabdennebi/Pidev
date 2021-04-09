
package tp.spring.boot.piedvdari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tp.spring.boot.piedvdari.entities.Visit;
import tp.spring.boot.piedvdari.repository.IVisitRepository;

@Service
public class GestionVisit implements IVisitService {
	
	@Autowired
	IVisitRepository rep;

	@Override
	public void ajouterVisit(Visit v) {
		rep.save(v);
		
	}

	@Override
	public void deleteVisit(int id) {
		rep.deleteById(id);
		
	}

	@Override
	public Visit updateVisit(Visit v) {
		rep.save(v);
		return v;
	}

	@Override
	public Visit retrieveVisit(int id) {
		return (rep.findById(id).orElse(null));
	}

	@Override
	public List<Visit> retrieveAllVisit() {
		return (List<Visit>) rep.findAll();
	}

}
