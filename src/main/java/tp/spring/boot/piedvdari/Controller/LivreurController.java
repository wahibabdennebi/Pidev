package tp.spring.boot.piedvdari.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tp.spring.boot.piedvdari.entities.Assurance;
import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.Livreurs;
import tp.spring.boot.piedvdari.services.ILivreurService;

@Controller 
public class LivreurController {
	
	@Autowired
	ILivreurService ilivreurservice;

	@PostMapping("/ajouterLivreur")
	@ResponseBody
//  http://localhost:8083/SpringMVC/servlet/ajouterLivreur #POST
	public void ajouterLivreur(@RequestBody Livreurs livreur) {
		ilivreurservice.ajouterLivreur(livreur);
	}
	 //  http://localhost:8083/SpringMVC/servlet/supprimerLivreur #DELETE
		@PostMapping("/supprimerLivreur")
		@ResponseBody
		public void supprimerAssurance(@RequestBody Livreurs livreur) {
			ilivreurservice.supprimerLivreur(livreur);
		}
		 //  http://localhost:8083/SpringMVC/servlet/modiferLivreur #UPDATE
			@PostMapping("/modiferLivreur")
			@ResponseBody
			public Livreurs modiferLivreur(@RequestBody Livreurs livreur) {
				ilivreurservice.modiferLivreur(livreur);
				return livreur;
			}
			// http://localhost:8081/SpringMVC/servlet/AffecterLivreur #PUT
			  @PutMapping("/affecterLivreur")
			    public ResponseEntity<Livreurs> affecter_livraison(@PathVariable("id") Long id, @RequestBody  Livreurs livreur,Furniture furniture) 
			  {
			        return new ResponseEntity<>(this.ilivreurservice.affecter_livraison(livreur,furniture), HttpStatus.OK);
			    }
			// http://localhost:8081/SpringMVC/servlet/LivreurDisponible #GET
			  @GetMapping("/LivreurDisponible")
			    public ResponseEntity<String> livreur_disponible(@PathVariable("id") Long id, @RequestBody  Livreurs livreur) 
			  {
			        return new ResponseEntity<>(this.ilivreurservice.livreur_disponible(livreur), HttpStatus.OK);
			    }
			  
			  
		
}
