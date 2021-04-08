
package tp.spring.boot.piedvdari.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import tp.spring.boot.piedvdari.PaymentIntentDto;
import tp.spring.boot.piedvdari.PaymentIntentDto.Currency;
import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.ImageModel;
import tp.spring.boot.piedvdari.entities.Order;
import tp.spring.boot.piedvdari.entities.Type;
import tp.spring.boot.piedvdari.repository.IOrderRepository;
import tp.spring.boot.piedvdari.service.FornitureService;
import tp.spring.boot.piedvdari.service.IFornitureService;
import tp.spring.boot.piedvdari.service.IPaymentService;

@RestController
@RequestMapping("/furniture")
public class FurnitureResource {
	@Autowired
  IFornitureService fornitureService	;
	@Autowired
	IPaymentService paymentService;

public FurnitureResource(FornitureService fornitureService) {
	super();
	this.fornitureService = fornitureService;
}
//http://localhost:8081/furniture//alltrue
@GetMapping("/alltrue")
public ResponseEntity<List<Furniture>> getAllFurnituresTrue(){
	List<Furniture> furnitures=fornitureService.findAllFurnitureByState();
	return new ResponseEntity<>(furnitures, HttpStatus.OK);
}
//http://localhost:8081/furniture/all
@GetMapping("/all")
public ResponseEntity<List<Furniture>> getAllFurnitures (){
	List<Furniture> furnitures=fornitureService.findAllFurniture();
	return new ResponseEntity<>(furnitures, HttpStatus.OK);
}
//http://localhost:8081/furniture/add

@PostMapping("/add")
public ResponseEntity<Furniture> addFurnitures(@RequestBody Furniture furniture){
	Furniture newfurniture= fornitureService.addForniture(furniture);
	return new ResponseEntity<>(newfurniture, HttpStatus.CREATED);	
}
//http://localhost:8081/furniture/costmers/1/add
@PostMapping("/costmers/{costmers_id}/add")
public ResponseEntity<Furniture> addFurnitures2(@PathVariable("costmers_id") int id,@RequestBody Furniture furniture){
	Furniture newfurniture= fornitureService.addForniture2(id, furniture);
	return new ResponseEntity<>(newfurniture, HttpStatus.CREATED);	
}

//http://localhost:8081/furniture/update
@PutMapping("/update")
public ResponseEntity<Furniture> updateFurnitures(@RequestBody Furniture furniture){
	Furniture updatefurniture= fornitureService.UpdateFurniture(furniture);
	return new ResponseEntity<>(updatefurniture, HttpStatus.OK);

}
//http://localhost:8081/furniture/delete/
@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteFurnitures(@PathVariable("id") int id){
	 fornitureService.deleteFurniture(id);
	return new ResponseEntity<>( HttpStatus.OK);
}

@GetMapping("/one/{id}")
public ResponseEntity<Furniture> getFurniture (@PathVariable("id") int id){
	 Furniture furniture=fornitureService.findFurniture(id);
	return new ResponseEntity<>(furniture, HttpStatus.OK);
}
//http://localhost:8081/furniture/saerch/
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
	Long price= fornitureService.getPrice(furniture_id, costmers_id);
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

@GetMapping("/a/{type}")
public ResponseEntity<List<Furniture>> getFurnitureByType (@PathVariable("type") Type t){
	List<Furniture> furnitures=fornitureService.findByType(t);
	return new ResponseEntity<>(furnitures, HttpStatus.OK);
}
@GetMapping("exuterpro/{promotion_id}")
public ResponseEntity<?> exuterpromotion(@PathVariable("promotion_id")int id)
{
	List<Furniture> listpro=fornitureService.exuterpromotion(id);
	return new ResponseEntity<>(listpro,HttpStatus.OK);
	
}
//http://localhost:8081/furniture/orderfurniture/
@PostMapping("orderfurniture/{furniture_id}")
public ResponseEntity<Order> addorder(@PathVariable("furniture_id")int id) throws StripeException
{
	Order order=fornitureService.addorder(id);
	PaymentIntentDto p= new PaymentIntentDto();
	p.setAmount(order.getFurniture().getPrice());
	p.setDescription(order.getFurniture().getTitre());
	p.setCurrency(Currency.eur);
	//paymentService.paymentIntent(p);
	//paymentService.creatCustmer(1);
	//paymentService.addCardCustomer();
	//paymentService.chargeCustomer();
	paymentService.confirm("pi_1Idj5DL1DK3MzZnFaIrbE93O");
	return new ResponseEntity<>(order,HttpStatus.OK);
	
}

}
