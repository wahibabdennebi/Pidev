package tp.spring.boot.piedvdari.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Bank;
import tp.spring.boot.piedvdari.repository.IBankRepository;
//import org.springframework.mail.javamail.JavaMailSender;

@Service
public class GestionBank implements IBankService {
	@Autowired
	IBankRepository bkr;
	
	@Autowired
	public JavaMailSender emailSender;

	@Override
	public void ajouterBank(Bank bk) {
		bkr.save(bk);
		
	}

	@Override
	public void deleteBank(int id) {
		bkr.deleteById(id);
		
	}

	@Override
	public Bank updateBank(Bank b) {
		bkr.save(b);
		return b;
	}

	@Override
	public Bank retrieveBank(int id) {
		return (bkr.findById(id).orElse(null));
	}

	@Override
	public List<Bank> retrieveAllBank() {
		return (List<Bank>) bkr.findAll();
	}

	@Override
	public float Rappel(Bank bk,int idBank) {
		 LocalDateTime localDate = LocalDateTime.now();
		 float res=0;
		
		Date dateAvant=bkr.findById(idBank).get().getDate_tmm();		
		
		Date dateApres=Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		 float diff = dateApres.getTime() - dateAvant.getTime();
		try{
	    res=(diff / (1000*60*60*24));
	    		
       if (res <= 210.0){
			
    	   SimpleMailMessage message = new SimpleMailMessage();
			//message.setTo("mariem.neji1@esprit.tn"); 
			message.setTo(bkr.findById(idBank).get().getMail()); 
			message.setSubject("Rappel"); 
			message.setText("Vous devez changer le Taux d'intérêt");
		   this.emailSender.send(message);
			
        }
     } catch (Exception e) {
         e.printStackTrace();
     }
		return(res)	;
  }

	@Override
	public float mensualite(int id,int emprunt,int periode) {
	  // double  x = (double) 1+(bkr.findById(id).get().getTaux_int()/12);
	   return (emprunt*(bkr.findById(id).get().getTaux_int()/1200))/(1-(float)Math.pow(1+(bkr.findById(id).get().getTaux_int()/1200),-periode));
	}
	

}
