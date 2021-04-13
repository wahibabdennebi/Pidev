package tp.spring.boot.piedvdari;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tp.spring.boot.piedvdari.services.IPackService;






@SpringBootTest
@RunWith(SpringRunner.class)
public class PiedvDariApplicationTests {
	@Autowired
    IPackService packservice;
	public static final Logger l = LogManager.getLogger(IPackService.class);
	@Test
	public final void contextLoads() {
		//Pack p= new Pack(50,"sqdq");
		
		//Pack p1= new Pack(70);
		//packservice.ajouterPack(p1);
		//l.info("ajouterPack" +p1);
		//packservice.supprimerPack(p);
		//packservice.modiferPack(p);
	}
	

}
