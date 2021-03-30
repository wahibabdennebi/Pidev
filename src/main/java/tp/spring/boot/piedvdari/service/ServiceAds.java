package tp.spring.boot.piedvdari.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import tp.spring.boot.piedvdari.entities.Ads;
import tp.spring.boot.piedvdari.entities.Category;
import tp.spring.boot.piedvdari.entities.City;
import tp.spring.boot.piedvdari.entities.Favorite_Ads;
import tp.spring.boot.piedvdari.entities.Type_ads;
import tp.spring.boot.piedvdari.entities.User;

public interface ServiceAds {
	public Ads ajouterAds(Ads a);
	public void deleteAds(int d);
	public  List<Ads> FindallAds();
	public Ads updateAds(Ads u);
	public Optional<Ads>findAdsbyId(int id);
	public User ajouterUser(User b);
	public List<Ads> search (String title,Category category,City city,Type_ads type_ads);
	public List<User> FindallUser();
	public void ajouterFavorite(Favorite_Ads f);
	public List<Favorite_Ads> FindallFavorite();
	public void deleteFavAd(int d);
	public  String addOneDay(String date);
	public void findFav(int a);
	public List<Favorite_Ads> searchfav (User user,Ads ad);


}
