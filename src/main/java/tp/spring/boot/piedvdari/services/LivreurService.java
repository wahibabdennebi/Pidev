package tp.spring.boot.piedvdari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.Livreurs;
import tp.spring.boot.piedvdari.entities.Pack;
import tp.spring.boot.piedvdari.entities.Status;
import tp.spring.boot.piedvdari.repositories.FurnitureRepository;
import tp.spring.boot.piedvdari.repositories.LivraisonRepository;
@Service
public class LivreurService implements ILivreurService {
	
	@Autowired
	LivraisonRepository livrep;
	@Autowired
	FurnitureRepository furrep;
	public void ajouterLivreur(Livreurs livreur ){
		livrep.save(livreur);
		
	}
	@Override
	public void supprimerLivreur(Livreurs livreur) {
	livrep.deleteById(livreur.getId_livreur());
	}
	@Override
	public Livreurs modiferLivreur(Livreurs livreur) {
		return livrep.save(livreur);
		
	}
	@Override
	public Livreurs affecter_livraison(Livreurs livreur,Furniture furniture ) {
		if(livreur.getCity()==furniture.getCity()){
			livreur.setStatus(Status.Disponible);
			
			}
		else {
			livreur.setStatus(Status.Non_Disponible);
		}
		return this.livrep.save(livreur);
		
		
	}
	public String livreur_disponible(Livreurs livreur){
		String h = null;
		if(livreur.getStatus()==Status.Disponible){
			h="le livreur est disponible";
			
			
		}
		else if  (livreur.getStatus()==Status.Non_Disponible){
			 h="le livreur est non disponible,votre ordre va etre livrée";
		}
		return h;
		
		
	}
	

}
