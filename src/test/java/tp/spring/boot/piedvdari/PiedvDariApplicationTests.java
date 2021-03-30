package tp.spring.boot.piedvdari;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tp.spring.boot.piedvdari.entities.Ads;
import tp.spring.boot.piedvdari.entities.Category;
import tp.spring.boot.piedvdari.entities.City;
import tp.spring.boot.piedvdari.service.ServiceAds;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PiedvDariApplicationTests {
@Autowired
ServiceAds service;
	@Test
	public void contextLoads() {
		//Ads ad = new Ads( "dhia", "s plus ", 200, "cite nozha", 20, 40, "rent", Category.apartement, City.Beja);
		
		//service.ajouterAds(ad);
		
	}

}
