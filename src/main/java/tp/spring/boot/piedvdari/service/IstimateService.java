package tp.spring.boot.piedvdari.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.City;
import tp.spring.boot.piedvdari.entities.Type_ads;
import tp.spring.boot.piedvdari.repositary.IRepositary;

@Service
public class IstimateService implements IEstimateAds {
@Autowired
IRepositary irepositaryads;
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
return price;
	}
	@Override
	public double estimate(int room, int area, Type_ads t, City c) {
		// TODO Auto-generated method stub
		Type_ads buy = Type_ads.buy;
		Type_ads rent =Type_ads.rent;
		double p;
		double pp=0;
		 Map<City, Double> estgraph = new HashMap<>();
		 estgraph.put(City.Ariana,(double) 1100);
		 estgraph.put(City.Tunis,(double) 800);
		 estgraph.put(City.Ben_arous,(double) 1000);
		 estgraph.put(City.Mannouba,(double) 800);
		 estgraph.put(City.Sousse,(double) 900);
		 estgraph.put(City.Nabeul,(double) 900);
		 estgraph.put(City.Bizerte,(double) 700);
		 estgraph.put(City.Jendouba,(double) 400);
		 estgraph.put(City.Siliana,(double) 400);
		 estgraph.put(City.Beja,(double) 400);
		 estgraph.put(City.Zaghouan,(double) 600);
		 estgraph.put(City.Sidi_bouzid,(double) 300);
		 estgraph.put(City.Gafsa,(double) 500);
		 estgraph.put(City.Gabes,(double) 450);
		 estgraph.put(City.Kasserine,(double) 300);
		 estgraph.put(City.Kebeli,(double) 350);
		 estgraph.put(City.Kef,(double) 450);
		 estgraph.put(City.Mahdia,(double) 600);
		 estgraph.put(City.Medennine,(double) 300);
		 estgraph.put(City.Tataouin,(double) 200);
		 estgraph.put(City.Sfax,(double) 800);
		 estgraph.put(City.Touzuer,(double) 500);
		 estgraph.put(City.Mounastir,(double) 850);
		 
		if (buy.equals(t)){
			if (estgraph.containsKey(c)){
				p=area* (estgraph.get(c));
				pp=p+((p*0.05)*room);
			}
		
		};
		
		if (rent.equals(t)){
			if (estgraph.containsKey(c)){
				p=area* (estgraph.get(c)*1/200);
				pp=(p+((p*0.05)*room));
			}
		};
		
		
		
		return pp;
	}
}
		


