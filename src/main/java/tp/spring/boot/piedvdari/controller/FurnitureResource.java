
package tp.spring.boot.piedvdari.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.ImageModel;
import tp.spring.boot.piedvdari.service.FornitureService;

@RestController
@RequestMapping("/furniture")
public class FurnitureResource {
	
private  FornitureService fornitureService	;


public FurnitureResource(FornitureService fornitureService) {
	super();
	this.fornitureService = fornitureService;
}

@GetMapping("/alltrue")
public ResponseEntity<List<Furniture>> getAllFurnituresTrue(){
	List<Furniture> furnitures=fornitureService.findAllFurnitureByState();
	return new ResponseEntity<>(furnitures, HttpStatus.OK);
}

@GetMapping("/all")
public ResponseEntity<List<Furniture>> getAllFurnitures (){
	List<Furniture> furnitures=fornitureService.findAllFurniture();
	return new ResponseEntity<>(furnitures, HttpStatus.OK);
}

@PostMapping("/add")
public ResponseEntity<Furniture> addFurnitures(@RequestBody Furniture furniture){
	Furniture newfurniture= fornitureService.addForniture(furniture);
	return new ResponseEntity<>(newfurniture, HttpStatus.CREATED);	
}
@PostMapping("/costmers/{costmers_id}/add")
public ResponseEntity<Furniture> addFurnitures2(@PathVariable("costmers_id") int id,@RequestBody Furniture furniture){
	Furniture newfurniture= fornitureService.addForniture2(id, furniture);
	return new ResponseEntity<>(newfurniture, HttpStatus.CREATED);	
}


@PutMapping("/update")
public ResponseEntity<Furniture> updateFurnitures(@RequestBody Furniture furniture){
	Furniture updatefurniture= fornitureService.UpdateFurniture(furniture);
	return new ResponseEntity<>(updatefurniture, HttpStatus.OK);

}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteFurnitures(@PathVariable("id") int id){
	 fornitureService.deleteFurniture(id);
	return new ResponseEntity<>( HttpStatus.OK);
}

@GetMapping("/one/{id}")
public ResponseEntity<Optional<Furniture>> getFurniture (@PathVariable("id") int id){
	 Optional<Furniture> furniture=fornitureService.findFurniture(id);
	return new ResponseEntity<>(furniture, HttpStatus.OK);
}

@GetMapping("/saerch/{titre}/{price}")
public ResponseEntity<List<Furniture>> saerch(@PathVariable("titre") String titre,@PathVariable("price") int price){
	List<Furniture> furnitures=fornitureService.search(titre, price);
	return new ResponseEntity<>(furnitures, HttpStatus.OK);
}

@PostMapping("/costmers/{costmers_id}/{furniture_id}/buy")
public ResponseEntity<Furniture> BuyFurnitures(@PathVariable("costmers_id") int costmers_id,@PathVariable("furniture_id") int furniture_id){
	fornitureService.byFurniture(costmers_id,furniture_id);
	return new ResponseEntity<>( HttpStatus.OK);
}

@GetMapping("/costmers/{costmers_id}/{furniture_id}/price")
public ResponseEntity<?> priceFurniture(@PathVariable("costmers_id") int costmers_id,@PathVariable("furniture_id") int furniture_id){
	int price= fornitureService.getPrice(furniture_id, costmers_id);
	return new ResponseEntity<>( price,HttpStatus.OK);	
}
@GetMapping("/Furniturecos/{id}")
public ResponseEntity<List<Furniture>> getFurniturecos (@PathVariable("id") int id){
	List<Furniture> furniture=fornitureService.getAllFornituresByCostumerId(id);
	return new ResponseEntity<>(furniture, HttpStatus.OK);
}
@GetMapping("/FurnitureImages/{id}")
public ResponseEntity<List<ImageModel>> getImagesByIdOfFurniture (@PathVariable("id") int id){
	List<ImageModel> imgs=fornitureService.getAllImagesByFurnitureId(id);
	return new ResponseEntity<>(imgs, HttpStatus.OK);
}

}
