package tp.spring.boot.piedvdari.service;


import java.util.List;

import tp.spring.boot.piedvdari.entities.Visit;

public interface IVisitService {
	public void ajouterVisit(Visit v);
	public void deleteVisit(int id);
	public Visit updateVisit(Visit v);
	public Visit retrieveVisit(int id);
	public List<Visit> retrieveAllVisit();

}
