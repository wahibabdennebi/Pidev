package tp.spring.boot.piedvdari.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Favorite_Ads;
import tp.spring.boot.piedvdari.repositary.IRepositaryFavoritAds;

@Service
public class FavoriteService implements IFavoriteService {
@Autowired 
IRepositaryFavoritAds favoritads;

	@Override
	public void ajouterFavorite(Favorite_Ads f) {
		// TODO Auto-generated method stub
		favoritads.save(f);
	}

	@Override
	public List<Favorite_Ads> FindallFavorite() {
		// TODO Auto-generated method stub
		LocalDateTime localDate=LocalDateTime.now();
		Date date2 = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		List<Favorite_Ads> favorites = new ArrayList<>();
	List <Favorite_Ads> favoritee = favoritads.findAll();
	
	 for (Favorite_Ads f : favoritee) {
		 float difference = date2.getTime()- f.getFav_ad_date().getTime();
		 float resultat = (difference/(1000*60*60*24));
		 if (resultat<3.0){
			 favorites.add(f);
			// System.out.println("test" +f);
		 }
		 else if (resultat>3.0){
			favoritads.deleteById(f.getId_favorite());
		 }
		
	}
	
	
	
	
	
	return favorites;
	}

	@Override
	public void deleteFavAd(int d) {
		// TODO Auto-generated method stub
		favoritads.deleteById(d);
		
	}

	@Override
	public void UpdateFavorite(int IdFav,Favorite_Ads f) {
		// TODO Auto-generated method stub
		Favorite_Ads a = favoritads.findById(IdFav).orElse(null);
		a.setFav_ad_date(f.getFav_ad_date());
		favoritads.save(a);
		
		
		
	}

}
