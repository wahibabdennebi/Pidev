package tp.spring.boot.piedvdari.service;

import tp.spring.boot.piedvdari.entities.City;
import tp.spring.boot.piedvdari.entities.Type_ads;

public interface IEstimateAds {
	public int[] EstimatedPrice(int room ,Type_ads s );
	public double estimate(int room , int area , Type_ads t,City c);

}
