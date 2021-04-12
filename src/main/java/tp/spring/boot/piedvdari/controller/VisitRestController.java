package tp.spring.boot.piedvdari.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import tp.spring.boot.piedvdari.entities.Visit;
import tp.spring.boot.piedvdari.service.IVisitService;

@RestController
public class VisitRestController {
	@Autowired
	IVisitService visitserv;
	
	//http://localhost:8082/SpringMVC/servlet/ajouterVisit
	
		@PostMapping("/ajouterVisit")
		public Visit addEmpl(@RequestBody Visit v){
			visitserv.ajouterVisit(v);
			return v;
		}
		//http://localhost:8082/SpringMVC/servlet/getAllVisit
		@GetMapping("/getAllVisit")
		public List<Visit> getall(){
			return visitserv.retrieveAllVisit();
			
		}
		//http://localhost:8082/SpringMVC/servlet/getByIdVisit/1
		@GetMapping("/getById/{idVisit}")
		public Visit getById(@PathVariable ("idVisit") int id_visit ){
			return visitserv.retrieveVisit(id_visit);
			
		}
		//http://localhost:8082/SpringMVC/servlet/updateVisit
		@PutMapping("/updateVisit")
		public Visit update(@RequestBody Visit v){
			return visitserv.updateVisit(v);
		}
		//http://localhost:8082/SpringMVC/servlet/deleteVisit/1
		@DeleteMapping("/deleteVisit/{id}")
		public void delete(@PathVariable("id") int id_visit){
			visitserv.deleteVisit(id_visit);
		}
		
		

}
