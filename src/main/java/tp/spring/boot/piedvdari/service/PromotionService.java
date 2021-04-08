package tp.spring.boot.piedvdari.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Admin;
import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.Promotion;
import tp.spring.boot.piedvdari.entities.Type;
import tp.spring.boot.piedvdari.repository.IAdminRepository;
import tp.spring.boot.piedvdari.repository.IFurnitureRepository;
import tp.spring.boot.piedvdari.repository.IPromtionRepository;

@Service
public class PromotionService implements IPromotionService {
	@Autowired
	IPromtionRepository promtionRep;
	@Autowired
	IAdminRepository adminRep;
	@Autowired
	IFornitureService fornitureser;
	
	@Override
	public Promotion addPromotion(int id,Promotion pro) {
		Admin a= adminRep.findById(id).orElse(null);
		pro.setAdmins(a);
		return promtionRep.save(pro);
	}
	
	@Override
	//promotion selon type de meuble 
	public List<Furniture> exuterpromotion(int id) {
		LocalDateTime localDate = LocalDateTime.now();
		Promotion p= promtionRep.findById(id).orElse(null);
		Type t=p.getType();
		int value=p.getValue();
		Date datefin= p.getDatefin();
	//date datedebut=p.getDatefin();
		Date datejour=Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		float diff = datefin.getTime()- datejour.getTime() ;
		float es=(diff / (1000*60*60*24));
		List<Furniture>nlistfur=new ArrayList<>();
		List<Furniture> F= fornitureser.findByType(p.getType());
			if(es<=0) {
				promtionRep.deleteById(id);
				System.out.println("test"+es);
				return F;
			}  else {
				for(Furniture f:F) {
					
				Long price = f.getPrice();
				price =price-((price*value)/100);
				f.setPrice(price);
				nlistfur.add(f);
				System.out.println("test"+es);
				
			}             
				return nlistfur;	
	
		}
			
		
	}
	
}
