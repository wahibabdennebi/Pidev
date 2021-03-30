package tp.spring.boot.piedvdari;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tp.spring.boot.piedvdari.service.IFornitureService;
@SpringBootTest 
@RunWith(SpringRunner.class)
public class PiedvDariApplicationTests {
	@Autowired
	IFornitureService IFo;
	
	@Test
	public void contextLoads() {
	//	Furniture f= new Furniture(60, "description", "titre");
		//IFo.addForniture(f);
		//IFo.deleteFurniture(0);
		
	
		
	
		
	}

}
