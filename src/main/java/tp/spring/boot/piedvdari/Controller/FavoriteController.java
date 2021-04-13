package tp.spring.boot.piedvdari.Controller;

import java.util.List;

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

import tp.spring.boot.piedvdari.entities.Favorite_Ads;
import tp.spring.boot.piedvdari.service.IFavoriteService;

@RestController
@RequestMapping("Favorite")
public class FavoriteController {
	@Autowired
	IFavoriteService favorite;
	//http://localhost:8084/Favorite/ajouterfavorite
	@PostMapping("/ajouterfavorite")
	public ResponseEntity <?> ajouterFavorite(@RequestBody Favorite_Ads fav){
		 favorite.ajouterFavorite(fav);
		 return new ResponseEntity<>(HttpStatus.CREATED);
 
		 }
	//http://localhost:8084/Favorite/all/favorite
	@GetMapping("/all/favorite")
	 public ResponseEntity <List<Favorite_Ads>> FindallFavorite(){
		 List<Favorite_Ads> favlist=favorite.FindallFavorite();
		 return new ResponseEntity<>(favlist,HttpStatus.OK);
	 }
	//http://localhost:8084/deletefavorite/id
	@DeleteMapping("/deletefavorite/{id}")
	public ResponseEntity <?> deletefav(@PathVariable("id") int id){
		 favorite.deleteFavAd(id);
		 return new ResponseEntity<>(HttpStatus.OK);
		 }
	@PutMapping("/Update/{IdFav}")
	public ResponseEntity <?> updatefavarite(@RequestBody @PathVariable("IdFav") int IdFav, Favorite_Ads f){
		 favorite.UpdateFavorite(IdFav, f);
		 return new ResponseEntity<>(HttpStatus.CREATED);

		 }

}
