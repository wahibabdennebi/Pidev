package tp.spring.boot.piedvdari.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Ads;
import tp.spring.boot.piedvdari.entities.Category;
import tp.spring.boot.piedvdari.entities.City;
import tp.spring.boot.piedvdari.entities.Favorite_Ads;
import tp.spring.boot.piedvdari.entities.Type_ads;
import tp.spring.boot.piedvdari.entities.User;
import tp.spring.boot.piedvdari.repositary.IRepositary;
import tp.spring.boot.piedvdari.repositary.IRepositaryFavoritAds;
import tp.spring.boot.piedvdari.repositary.IRepsitaryUser;
@Service
public class Serviceclassad implements ServiceAds{
@Autowired
IRepositary irepositary;
@Autowired
IRepsitaryUser irepositaryuser;
@Autowired
IRepositaryFavoritAds irepositaryfavroitsAds;
	@Override
	public Ads ajouterAds(Ads a) {
	
		
		return irepositary.save(a);
	}
	@Override
	public void deleteAds(int d) {
		irepositary.deleteById(d);
		
	}
	@Override
	public List<Ads> FindallAds() {
		// TODO Auto-generated method stub
		return irepositary.findAll();
		
	}
	@Override
	public Ads updateAds(Ads u) {
		
		return irepositary.save(u);
	}
	@Override
	public Optional<Ads> findAdsbyId(int id) {
		
		return irepositary.findById(id);
	}
	@Override
	public User ajouterUser(User b) {
		
		return irepositaryuser.save(b);
	}
	@Override
	public List<Ads> search(String title, Category category, City city,Type_ads type_ads) {
		// TODO Auto-generated method stub
		return irepositary.findByTitleAndCategoryAndCity(title, category, city,type_ads);
	}
	@Override
	public List<User> FindallUser() {
		// TODO Auto-generated method stub
		return irepositaryuser.findAll();
	}
	@Override
	public void ajouterFavorite(Favorite_Ads f) {
		// TODO Auto-generated method stub
		 irepositaryfavroitsAds.save(f);
		int i =f.getId_favorite();
		findFav(i);
		}
	@Override
	public List<Favorite_Ads> FindallFavorite() {
		// TODO Auto-generated method stub
		return irepositaryfavroitsAds.findAll();
	}
	@Override
	public void deleteFavAd(int d) {
		// TODO Auto-generated method stub
		irepositaryfavroitsAds.deleteById(d);
		
	}
	@Override
	public  String addOneDay(String date) {
	    return LocalDate
	      .parse(date)
	      .plusDays(3)
	      .toString();
	}
	@Override
	public void  findFav(int a) {
		// TODO Auto-generated method stub
		Favorite_Ads f = irepositaryfavroitsAds.getOne(a);
		Date date = f.getFav_ad_date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
					c.setTime(date); // Now use today date.
		c.add(Calendar.DATE, 4);
		// Adding 5 days
		Date d = c.getTime();
		Date Dateoftheday= new Date();
		if (date != Dateoftheday){
			f.setFav_ad_date(Dateoftheday);
			
			irepositaryfavroitsAds.save(f);
		}
		Date s = f.getFav_ad_date();
		if  (s.compareTo(d) > 0){
			f.setStates(false);
			irepositaryfavroitsAds.save(f);
		}

		
		
		
		
		
		
		
		 		
		
	}
	@Override
	public List<Favorite_Ads> searchfav(User user, Ads ad) {
		// TODO Auto-generated method stub
		return irepositaryfavroitsAds.findByUser_idAndAd_idAndStates(user, ad);
	}
	
		
	}
	
	


