package tp.spring.boot.piedvdari.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.Bank;
import tp.spring.boot.piedvdari.service.IBankService;

@RestController
public class BankRestController {
	@Autowired
	IBankService bankserv;
	
	//http://localhost:8082/SpringMVC/servlet/ajouterBank
	@PostMapping("/ajouterBank")
	public Bank addBank(@RequestBody Bank bk){
		bankserv.ajouterBank(bk);;
		return bk;
	}
	//http://localhost:8082/SpringMVC/servlet/getAllBank
	@GetMapping("/getAllBank")
	public List<Bank> getall(){
		return bankserv.retrieveAllBank();
		
	}
	//http://localhost:8082/SpringMVC/servlet/getById/4
	@GetMapping("/getById/{idBank}")
	public Bank getById(@PathVariable ("idBank") int id_bank ){
		return bankserv.retrieveBank(id_bank);
		
	}
	//http://localhost:8082/SpringMVC/servlet/updateBank
	@PutMapping("/updateBank")
	public Bank update(@RequestBody Bank bk){
		return bankserv.updateBank(bk);
	}
	//http://localhost:8082/SpringMVC/servlet/deleteBank/1
	@DeleteMapping("/deleteBank/{id}")
	public void delete(@PathVariable("id") int id_bank){
		bankserv.deleteBank(id_bank);
	}
	//http://localhost:8082/SpringMVC/servlet/Rappel/4
	@PostMapping("/Rappel/{id}")
	@ResponseBody
	public float Rappel(Bank bk,@PathVariable ("id")int idBank){
		 return bankserv.Rappel(bk,idBank);
  }
	//http://localhost:8082/SpringMVC/servlet/getMensualite/4/1500/3
	@GetMapping("/getMensualite/{id}/{empt}/{perd}")
	public float getMensualite(@PathVariable ("id") int id_bank,@PathVariable ("empt") int emprunt,@PathVariable ("perd") int periode){
		return bankserv.mensualite(id_bank, emprunt, periode);
	}


}
