package tp.spring.boot.piedvdari.service;


import java.util.List;
import java.util.Optional;

import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.ImageModel;

public interface IFornitureService {
	public Furniture addForniture(Furniture f);
	public Furniture UpdateFurniture(Furniture furniture);
	public void deleteFurniture(int id) ;
	public List<Furniture> findAllFurniture();
	public Optional<Furniture> findFurniture(int id);
	public List<Furniture> search (String titre,int price);
	public List<Furniture> findAllFurnitureByState();
	public void byFurniture(int id_client,int furniture_id);
	
	Furniture addForniture2(int id, Furniture f);
	 int getPrice(int furniture_id, int id_client);
	 public List<Furniture> getAllFornituresByCostumerId(int costumersid);
	List<ImageModel> getAllImagesByFurnitureId(int furniture) ;
	
		
	

}
