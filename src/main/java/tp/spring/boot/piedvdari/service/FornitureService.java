package tp.spring.boot.piedvdari.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.Costumer;
import tp.spring.boot.piedvdari.entities.Furniture;
import tp.spring.boot.piedvdari.entities.ImageModel;
import tp.spring.boot.piedvdari.entities.Order;
import tp.spring.boot.piedvdari.entities.Promotion;
import tp.spring.boot.piedvdari.entities.Type;
import tp.spring.boot.piedvdari.repository.ICostmerRepository;
import tp.spring.boot.piedvdari.repository.IFurnitureRepository;
import tp.spring.boot.piedvdari.repository.IOrderRepository;
import tp.spring.boot.piedvdari.repository.IPromtionRepository;
@Service
public class FornitureService implements IFornitureService{
	@Autowired
	public IFurnitureRepository furnitureRepository;
	@Autowired
	public ICostmerRepository costmerRepository;
	@Autowired 
	public ImageService imageService ;
	@Autowired
	IPromtionRepository promtionRep;
	@Autowired
	IOrderRepository orderRepo;
	@Autowired
	IPaymentService paymentService;
	 
	@Override
	public Furniture addForniture(Furniture f) {
		
		return furnitureRepository.save(f);
		
	}
	
	@Override
	public Furniture addForniture2(int id,Furniture f) {
		Costumer costumer = costmerRepository.getOne(id);
		f.setCostumer(costumer);
		
		return furnitureRepository.save(f);
		
	}
	


	@Override
	public void deleteFurniture(int id) {
		furnitureRepository.deleteById(id);
		
	}


	@Override
	public Furniture UpdateFurniture(Furniture furniture) {
		return furnitureRepository.save(furniture);
		
	}


	@Override
	public List<Furniture> findAllFurniture() {
		return furnitureRepository.findAll();
		
	}




	@Override
	public Furniture findFurniture(int id) {
		
		return furnitureRepository.findById(id).orElse(null);
				}




	@Override
	public List<Furniture> search(String titre, int price) {
		
		return furnitureRepository.findByTitreAndPrice(titre, price);
	}

	


	@Override
	public List<Furniture> findAllFurnitureByState() {
		return furnitureRepository.findBystate();
	}

	@Override
	public void byFurniture(int id_client ,int furniture_id) {
		Furniture updatefurniture=furnitureRepository.getOne(furniture_id);
		updatefurniture.setState(false);
		Costumer costumer=costmerRepository.getOne(id_client);
		int x= costumer.getPoint_fid();
		if (x>=100) {
			costumer.setPoint_fid(x-90);
			costmerRepository.save(costumer);
		}else {
			costumer.setPoint_fid(x+10);	
			costmerRepository.save(costumer);
		}
		  furnitureRepository.save(updatefurniture);
	}
		
		@Override
		public Long getPrice(int furniture_id, int id_client) {
			Costumer costumer=costmerRepository.getOne(id_client);
			Furniture furniture=furnitureRepository.getOne(furniture_id);
			Long price =furniture.getPrice();
			if (costumer.getPoint_fid()>=100) {
			return	price =price-((price *10)/100);
				
			}
				return price;
		}

		@Override
		public List<Furniture> getAllFornituresByCostumerId(int costumersid) {
			Costumer c= costmerRepository.findById(costumersid).orElse(null);
			List<Furniture> listforn=c.getListfurniture(); 
			return listforn;
		}
		@Override
		public List<ImageModel>getAllImagesByFurnitureId(int furnitureid){
			Furniture f = furnitureRepository.findById(furnitureid).orElse(null);
			 List<ImageModel>ListImages= f.getListImages();
			/* List<ImageModel>listimgs=new ArrayList<>();
			 for (ImageModel list:ListImages) {
				String name= list.getName();
				try {
					listimgs.add(imageService.getImage(name));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			 }*/
			 return ListImages;
			
		}

		@Override
		public List<Furniture> findByType(Type t) {
			// TODO Auto-generated method stub
			return furnitureRepository.findByType(t);
		}
		@Override
		public List<Furniture> exuterpromotion(int id) {
			Promotion p= promtionRep.findById(id).orElse(null);
			Type t=p.getType();
			int value=p.getValue();
			//List<Furniture>nlistfur=new ArrayList<>();
			List<Furniture> F= furnitureRepository.findByType(t.Accesoires);
			/*for(Furniture f:F) {
				int price = f.getPrice();
				price =((price*value)/100);
				f.setPrice(price);
				nlistfur.add(f);
			}*/
			return F;
		}

		@Override
		public Order addorder(int idfurniture) {
			Order o= new Order();
			o.setFurniture(findFurniture(idfurniture));	
			return orderRepo.save(o);
		}
	
}
