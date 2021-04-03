package tp.spring.boot.piedvdari.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.poi.util.SystemOutLogger;
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
public class Serviceclassad implements ServiceAds {
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
	public List<Ads> search(String title, Category category, City city, Type_ads type_ads) {
		// TODO Auto-generated method stub
		return irepositary.findByTitleAndCategoryAndCity(title, category, city, type_ads);
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
		int i = f.getId_favorite();
		findFav(i);
	}

	@Override
	public List<Favorite_Ads> FindallFavorite() {
		// TODO Auto-generated method stub
	
	
		LocalDateTime localDate=LocalDateTime.now();
		Date date2 = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		List<Favorite_Ads> favorites = new ArrayList<>();
	List <Favorite_Ads> favoritee = irepositaryfavroitsAds.findAll();
	
	 for (Favorite_Ads f : favoritee) {
		 float difference = date2.getTime()- f.getFav_ad_date().getTime();
		 float resultat = (difference/(1000*60*60*24));
		 if (resultat<3.0){
			 favorites.add(f);
			// System.out.println("test" +f);
		 }
		 else if (resultat>3.0){
			irepositaryfavroitsAds.deleteById(f.getId_favorite());
		 }
		 
		
		 
	 
	}
	
		
		
		
		return favorites;
	}

	@Override
	public void deleteFavAd(int d) {
		// TODO Auto-generated method stub
		irepositaryfavroitsAds.deleteById(d);

	}

	@Override
	public String addOneDay(String date) {
		return LocalDate.parse(date).plusDays(3).toString();
	}

	@Override
	
	public void findFav(int id) {
		// TODO Auto-generated method stub
		Favorite_Ads f = irepositaryfavroitsAds.getOne(id);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1;
		LocalDateTime localDate=LocalDateTime.now();
		date1 = f.getFav_ad_date();
		Date date2 = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		float diff=date2.getTime()-date1.getTime();
		try{
			float res=(diff/(1000*60*60*24));
			if(res>3.0){
				irepositaryfavroitsAds.deleteById(id);
			}
		}
		catch (Exception e ){
			e.printStackTrace();
		}
			// Algo pour comparer les 2 dates
		//int dif = date2.compareTo(date1);
		//System.err.println(date2 + "rfgg" + f.getFav_ad_date() + "vxlcnog" + dif);

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// Calendar c = Calendar.getInstance();
		// c.setTime(date); // Now use today date.
		// c.add(Calendar.DATE, 4);
		// // Adding 5 days
		// Date d = c.getTime();
		// Date Dateoftheday= new Date();
		// if (date != Dateoftheday){
		// f.setFav_ad_date(Dateoftheday);
		//
		// irepositaryfavroitsAds.save(f);
		// }
		// Date s = f.getFav_ad_date();
		// if (s.compareTo(d) > 0){
		// f.setStates(false);
		// irepositaryfavroitsAds.save(f);
		// }

	}

	@Override
	public List<Favorite_Ads> searchfav(User user, Ads ad) {
		// TODO Auto-generated method stub
		return irepositaryfavroitsAds.findByUser_idAndAd_idAndStates(user, ad);
	}

	@Override
	public int[] EstimatedPrice(int room,Type_ads s ) {
		// TODO Auto-generated method stub
		Type_ads type_ads = Type_ads.rent;
		Type_ads a = Type_ads.buy;
		int [] price={0};
		if (type_ads.equals(s)){
			
			if (room==1  ){
				 price =new int[]{100,200};	
			}
			else if (room==2){
				 price =new int[]{200,300};	
			}
			else if (room==3){
				 price =new int[]{300,400};	
			}
			else if (room>=4 ){
				price=new int[]{400,600};	
			}
		}
		
if (a.equals(s)){
			
			if (room==1  ){
				 price =new int[]{100000,200000};	
			}
			else if (room==2 ){
				 price =new int[]{200000,300000};	
			}
			else if (room==3 ){
				 price =new int[]{300000,400000};	
			}
			else if (room>=4  ){
				price=new int[]{400000,600000};	
			}
		}
		
		
		
	/*	if (room==1 && area >=50 && area<=100 ){
			 price =new int[]{100,200};	
		}
		else if (room==2){
			 price =new int[]{200,300};	
		}
		else if (room==3){
			 price =new int[]{300,400};	
		}
		else if (room>=4){
			price=new int[]{400,600};	
		}*/
		return price;
	}

}
