package tp.spring.boot.piedvdari.service;

import java.util.List;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.Promotion;

public interface IPromotionService {

	public Promotion addPromotion(int id,Promotion pro);
	public List<Furniture> exuterpromotion(int id);
}
