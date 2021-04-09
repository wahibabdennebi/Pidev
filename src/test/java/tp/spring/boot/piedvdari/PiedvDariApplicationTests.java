package tp.spring.boot.piedvdari;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import tp.spring.boot.piedvdari.entities.Bank;
import tp.spring.boot.piedvdari.entities.Borrower;
import tp.spring.boot.piedvdari.entities.Visit;
import tp.spring.boot.piedvdari.service.IBankService;
import tp.spring.boot.piedvdari.service.IBorrowerService;
import tp.spring.boot.piedvdari.service.IVisitService;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PiedvDariApplicationTests {

	private static final Logger l =  LogManager.getLogger(PiedvDariApplicationTests.class);
	
	@Autowired
	IVisitService serviceVisit;
	@Autowired
	IBorrowerService servicebr;
	@Autowired
	IBankService servicebk;
	
	@Test
	public void contextLoads() throws ParseException{
		
		l.info("Hello");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		//Date date = dateFormat.parse("07-06-2021");
		//Visit visit = new Visit(date, "Ariana");
		//Date date1 = dateFormat.parse("08-08-2021");
		//Visit visit1 = new Visit(date1, "Ariana");
		//serviceVisit.ajouterVisit(visit);
		//serviceVisit.ajouterVisit(visit1);
		//Date date2 = dateFormat.parse("09-06-2021");
		//Visit visit2 = new Visit(date2, "Manouba");
		//serviceVisit.ajouterVisit(visit2);
		
		//serviceVisit.deleteVisit(1);
		
		//Visit visitupdate = new Visit(4,date2,"Manar");
		//serviceVisit.updateVisit(visitupdate);
		//serviceVisit.retrieveAllVisit();
		//serviceVisit.retrieveVisit(4);
		
		//Borrower br = new Borrower(520);
		//Borrower br1 = new Borrower(1200);
		//Borrower br2 = new Borrower(1350);
		//servicebr.ajouterBorrower(br);
		//servicebr.ajouterBorrower(br1);
		//servicebr.ajouterBorrower(br2);
		//Borrower br3 = new Borrower(2100);
		//servicebr.ajouterBorrower(br3);
		//servicebr.deleteBorrower(7);
		//Borrower brr = new Borrower(5, 1650);
		//servicebr.updateBorrower(brr);
		//servicebr.retrieveAllBorrower();
		//servicebr.retrieveVisit(6);
		
		//Bank bk = new Bank("BIAT");
		//Bank bk1 = new Bank("Zitouna");
		//Bank bk2 = new Bank("BIAT");
		//Bank bk3 = new Bank("BIAT");
		//Bank bk4 = new Bank("Amen Bank");
		//servicebk.ajouterBank(bk);
		//servicebk.ajouterBank(bk1);
		//servicebk.ajouterBank(bk2);
		//servicebk.ajouterBank(bk3);
		//servicebk.ajouterBank(bk4);
		//servicebk.deleteBank(11);
		//Bank bk = new Bank(12,"QNB");
		//servicebk.updateBank(bk);
		
		
	}

}
