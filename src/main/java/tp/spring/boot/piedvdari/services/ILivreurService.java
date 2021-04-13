package tp.spring.boot.piedvdari.services;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.Livreurs;
import tp.spring.boot.piedvdari.entities.Pack;

public interface ILivreurService {
	
	public void ajouterLivreur(Livreurs livreur );

	public void supprimerLivreur(Livreurs livreur);

	public Livreurs modiferLivreur(Livreurs livreur);
	
	public Livreurs affecter_livraison(Livreurs livreur, Furniture furniture);
	public String livreur_disponible(Livreurs livreur);

}
