package tp.spring.boot.piedvdari.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.City;
import tp.spring.boot.piedvdari.entities.Type_ads;
import tp.spring.boot.piedvdari.service.IEstimateAds;

@RestController
@RequestMapping("Estimate")
public class EstimateController {
	@Autowired
	IEstimateAds estimateads;
	//http://localhost:8084/Estimate/5/rent
	@GetMapping("/{room}/{s}")
	 public ResponseEntity<?> EstimatedPrice(@PathVariable("room") int room ,@PathVariable("s")Type_ads s ){
		 int [] price= estimateads.EstimatedPrice(room ,s);
		 return new ResponseEntity<>(price,HttpStatus.OK);
	 }
	@GetMapping("/{room}/{area}/{type}/{city}")
	 public ResponseEntity<?> EstimatedPrice(@PathVariable ("room") int room, @PathVariable ("area") int area, @PathVariable ("type")Type_ads type, @PathVariable ("city")City city ){
		 double price= estimateads.estimate(room ,area,type,city);
		 return new ResponseEntity<>(price,HttpStatus.OK);
	 }

}
