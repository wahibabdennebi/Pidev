package tp.spring.boot.piedvdari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.Promotion;

import tp.spring.boot.piedvdari.service.IPromotionService;

@RestController
@RequestMapping("promotion")
public class PromotionResource {
	@Autowired
	IPromotionService promotionService;
	
	
	public PromotionResource(IPromotionService promotionService) {
		super();
		this.promotionService = promotionService;
	}


	@PostMapping("addpromotion/{admin_id}")
	public ResponseEntity<Promotion>addpromotion(@PathVariable("admin_id")int id,@RequestBody Promotion pro){
		Promotion prom= promotionService.addPromotion(id,pro);
		return new ResponseEntity<Promotion>(prom,HttpStatus.CREATED);
	}
	
	
	@GetMapping("exuterpro/{promotion_id}")
	public ResponseEntity<?> exuterpromotion(@PathVariable("promotion_id")int id)
	{
		List<Furniture> listpro=promotionService.exuterpromotion(id);
		return new ResponseEntity<>(listpro,HttpStatus.OK);
		
	}

}
