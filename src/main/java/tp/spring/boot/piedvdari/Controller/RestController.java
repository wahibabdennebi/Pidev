package tp.spring.boot.piedvdari.Controller;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tp.spring.boot.piedvdari.dao.Orderrequest;
import tp.spring.boot.piedvdari.entities.Ads;
import tp.spring.boot.piedvdari.entities.Category;
import tp.spring.boot.piedvdari.entities.City;
import tp.spring.boot.piedvdari.entities.Favorite_Ads;
import tp.spring.boot.piedvdari.entities.Type_ads;
import tp.spring.boot.piedvdari.entities.User;
import tp.spring.boot.piedvdari.repositary.IRepositaryFavoritAds;
import tp.spring.boot.piedvdari.repositary.IRepsitaryUser;
import tp.spring.boot.piedvdari.service.ExportAdsService;
import tp.spring.boot.piedvdari.service.ServiceAds;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/Ads")

public class RestController {
	
//	@Autowired
//	IRepsitaryUser irepsitaryuser;
//	@Autowired
//	IRepositaryFavoritAds irepositaryfavroitsAds;
	@Autowired
	ServiceAds serviceads;
	@Autowired
	 ExportAdsService exportService;
	
	
	
	 public RestController(ServiceAds serviceads) {
		super();
		this.serviceads = serviceads;
		
	}

	 @CrossOrigin(origins = "http://localhost:4200")
	 //http://localhost:8084/Ads/all
	@GetMapping("/all")
	 public ResponseEntity <List<Ads>> getAllAds(){
		 List<Ads> ads=serviceads.FindallAds();
		 return new ResponseEntity<>(ads,HttpStatus.OK);
	 }
	 @CrossOrigin(origins = "http://localhost:4200")
	//http://localhost:8084/Ads/add
	@PostMapping("/add")
	public ResponseEntity <Ads> ajouterAds(@RequestBody Ads ad){
		Ads newad = serviceads.ajouterAds(ad);
		 return new ResponseEntity<>(newad,HttpStatus.CREATED);
		 }
	//http://localhost:8084/Ads/update
	@PutMapping("/update")
	public ResponseEntity <Ads> updateAds(@RequestBody Ads ad){
		Ads updateemploye = serviceads.updateAds(ad);
		 return new ResponseEntity<>(updateemploye,HttpStatus.CREATED);
		 }
	//http://localhost:8084/Ads/delete/{id}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <?> deleteAds(@PathVariable("id") int id){
		 serviceads.deleteAds(id);
		 return new ResponseEntity<>(HttpStatus.OK);
		 }
	@CrossOrigin(origins = "http://localhost:4200")
	//http://localhost:8084/Ads/find/{id}
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Ads>> findAdsbyId(@PathVariable("id") int id){
		 Optional<Ads> finad=serviceads.findAdsbyId(id);
		 return new ResponseEntity<>(finad,HttpStatus.OK);
		 }
	@CrossOrigin(origins = "http://localhost:4200")
	//http://localhost:8084/Ads/search/title/category/city/type_ads
	@GetMapping("/search/{title}/{category}/{city}/{type_ads}")
	public ResponseEntity<List<Ads>> search(@PathVariable("title")String title,@PathVariable("category")Category category,@PathVariable("city")City city,@PathVariable("type_ads") Type_ads type_ads){
		List<Ads> nn = serviceads.search(title, category, city,type_ads);
		return new ResponseEntity<>(nn,HttpStatus.OK);
	}
	 @GetMapping("/allpagination")
		Page<Ads>	findpagination(@RequestParam int PageSize, @RequestParam int PageNumber){
	return (Page<Ads>) serviceads.Findpagination(PageNumber,PageSize);
	 }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/export/pdf")
		 public ResponseEntity <InputStreamResource> exportAdsPdf(){
			 List<Ads> ads = (List<Ads>) serviceads.FindallAds();
			 ByteArrayInputStream bais = exportService.adsPDFReport(ads);
			 HttpHeaders headers = new HttpHeaders();
			headers.add("Content-disposition ", "inline;filename =Ads.Pdf");
			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
		 }

	
//	@PostMapping("/user")
//	public ResponseEntity <User> ajouterUser(@RequestBody User bb){
//		User newuser = serviceads.ajouterUser(bb);
//		return new ResponseEntity<>(newuser,HttpStatus.CREATED);
//		 }
	//@PostMapping("/user")
	//public User ajouterUser(@RequestBody Orderrequest request){
		//return irepsitaryuser.save(request.getUser());
		 //}
	
	
//	@GetMapping("/all/User")
//	 public ResponseEntity <List<User>> FindallUser(){
//		 List<User> useruser=serviceads.FindallUser();
//		 return new ResponseEntity<>(useruser,HttpStatus.OK);
//	 }
//	
//	@PostMapping("/fav")
//	public ResponseEntity <?> ajouterFavorite(@RequestBody Favorite_Ads fav){
//		 serviceads.ajouterFavorite(fav);
//		 return new ResponseEntity<>(HttpStatus.CREATED);
// 
//		 }
//	@GetMapping("/all/fav")
//	 public ResponseEntity <List<Favorite_Ads>> FindallFavorite(){
//		 List<Favorite_Ads> favlist=serviceads.FindallFavorite();
//		 return new ResponseEntity<>(favlist,HttpStatus.OK);
//	 }
//
//	@DeleteMapping("/deletefav/{id}")
//	public ResponseEntity <?> deletefav(@PathVariable("id") int id){
//		 serviceads.deleteFavAd(id);
//		 return new ResponseEntity<>(HttpStatus.OK);
//		 }
//	@PostMapping("/all/favv/{id}")
//	 public ResponseEntity <?>  findFav(@PathVariable("id") int id){
//		serviceads.findFav(id);
//		 return new ResponseEntity<>(HttpStatus.CREATED);
//	 }
//	@GetMapping("/searchfav/{user}/{ad}/{states}")
//	public ResponseEntity<List<Favorite_Ads>> search(@PathVariable("user")User user,@PathVariable("ad")Ads ad){
//		List<Favorite_Ads> ff = serviceads.searchfav(user, ad);
//		return new ResponseEntity<>(ff,HttpStatus.OK);
//	}
	
	
//	 @GetMapping("/Estimated/{room}/{s}")
//	 public ResponseEntity<?> EstimatedPrice(@PathVariable("room") int room ,@PathVariable("s")Type_ads s ){
//		 int [] price= serviceads.EstimatedPrice(room ,s);
//		 return new ResponseEntity<>(price,HttpStatus.OK);
//	 }
	
	 
}
