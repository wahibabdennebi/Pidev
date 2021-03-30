package tp.spring.boot.piedvdari.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.Claim;
import tp.spring.boot.piedvdari.service.ClaimService;

@RestController
@RequestMapping(value="/claim")
public class ClaimResource {
	@Autowired
	public ClaimService claimService;
	
	
	public ClaimResource(ClaimService claimService) {
		super();
		this.claimService = claimService;
	}

		//
	@PostMapping("/{costumer_id}/{ads_id}/addclaim")
	public ResponseEntity<Claim> addclaim(@PathVariable("costumer_id") int id,@PathVariable("ads_id") int ida, @RequestBody Claim claim){
		Claim c = claimService.addClaim(id,ida,claim);
		return new ResponseEntity<Claim>(c, HttpStatus.CREATED);
	}
	

}
