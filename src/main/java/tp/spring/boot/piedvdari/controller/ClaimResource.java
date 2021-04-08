package tp.spring.boot.piedvdari.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.Claim;
import tp.spring.boot.piedvdari.service.ClaimService;
import tp.spring.boot.piedvdari.service.IClaimService;

@RestController
@RequestMapping(value="/claim")
public class ClaimResource {
	@Autowired
	public IClaimService claimService;
	
	
	public ClaimResource(ClaimService claimService) {
		super();
		this.claimService = claimService;
	}

	
	@PostMapping("addclaim/{costumer_id}/{ads_id}")
	public ResponseEntity<Claim> addclaim(@PathVariable("costumer_id") int id,@PathVariable("ads_id") int ida, @RequestBody Claim claim){
		Claim c = claimService.addClaim(id,ida,claim);
		return new ResponseEntity<Claim>(c, HttpStatus.CREATED);
	}
	
	//http://localhost:8081/claim/claimcostumer/1
	@GetMapping("claimcostumer/{costumer_id}")
	public ResponseEntity<List<Claim>>afficherClaimsCostumer(@PathVariable("costumer_id") int id){
		List<Claim> c= claimService.getAllClaimByCostumerId(id);
		return new ResponseEntity<List<Claim>>(c,HttpStatus.OK);
	}
	
	//http://localhost:8081/claim/allclaims
	@GetMapping("allclaims")
	public ResponseEntity<List<Claim>>getAllClaims(){
		List<Claim> c= claimService.findAllClaims();
		return new ResponseEntity<List<Claim>>(c,HttpStatus.OK);
		
	}
	@PutMapping("/updateclaim")
	public ResponseEntity<Claim>updateClaim(@RequestBody Claim claim ){
		Claim c = claimService.updateClaim(claim);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	//http://localhost:8081/claim/deleteAllClaim
	@DeleteMapping("deleteAllClaim")
	public ResponseEntity<?>deleleallclaim(){
		claimService.deleteAllClaim();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
