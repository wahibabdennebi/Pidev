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

import tp.spring.boot.piedvdari.entities.Borrower;
import tp.spring.boot.piedvdari.service.IBorrowerService;

@RestController
public class BorrowerRestController {
	@Autowired
	IBorrowerService borwserv;
	
	//http://localhost:8082/SpringMVC/servlet/ajouterBank
		@PostMapping("/ajouterBorrower")
		public Borrower addBorrower(@RequestBody Borrower br){
			borwserv.ajouterBorrower(br);
			return br;
		}
		//http://localhost:8082/SpringMVC/servlet/getAllBorrower
		
		@GetMapping("/getAllBorrower")
		public List<Borrower> getall(){
			return borwserv.retrieveAllBorrower();
			
		}
		//http://localhost:8082/SpringMVC/servlet/getByIdBorrower/1
		@GetMapping("/getByIdBorrower/{idBorw}")
		public Borrower getById(@PathVariable ("idBorw") int id_borrower ){
			return borwserv.retrieveBorrower(id_borrower);
			
		}
		//http://localhost:8082/SpringMVC/servlet/updateBorrower
		@PutMapping("/updateBorrower")
		public Borrower update(@RequestBody Borrower br){
			return borwserv.updateBorrower(br);
		}
		//http://localhost:8082/SpringMVC/servlet/deleteBank/1
		@DeleteMapping("/deleteBorrower/{id}")
		public void delete(@PathVariable("id") int id_borrower){
			borwserv.deleteBorrower(id_borrower);
		}
		//http://localhost:8082/SpringMVC/servlet/Capacite/4/1500/10
		@GetMapping("/Capacite/{id}/{salaire}/{periode}")
		public float capacite10(@PathVariable ("id") int id_Bank,@PathVariable ("salaire") int salaire,@PathVariable ("periode")int periode){
			return  borwserv.capaciteEmprunt(salaire, id_Bank,periode);
			
		}
		

}
