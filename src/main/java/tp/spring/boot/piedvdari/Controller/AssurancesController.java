package tp.spring.boot.piedvdari.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tp.spring.boot.piedvdari.entities.Assurance;
import tp.spring.boot.piedvdari.services.IAssurancesService;

@Controller
public class AssurancesController {
	@Autowired
	IAssurancesService iassuranceservice;
	 //  http://localhost:8083/SpringMVC/servlet/ajouterAssurance #POST
		@PostMapping("/ajouterAssurance")
		@ResponseBody
		public void ajouterAssurance(@RequestBody Assurance assurance) {
			iassuranceservice.ajouterAssurance(assurance);
		}
		 //  http://localhost:8083/SpringMVC/servlet/supprimerAssurance #DELETE
			@PostMapping("/supprimerAssurance")
			@ResponseBody
			public void supprimerAssurance(@RequestBody Assurance assurance) {
				iassuranceservice.supprimerAssurance(assurance);
			}
			 //  http://localhost:8083/SpringMVC/servlet/modiferAssurance #UPDATE
				@PostMapping("/modiferAssurance")
				@ResponseBody
				public Assurance modiferAssurance(@RequestBody Assurance assurance) {
					iassuranceservice.modiferAssurance(assurance);
					return assurance;
				}
	

}
