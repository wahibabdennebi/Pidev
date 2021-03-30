package tp.spring.boot.piedvdari.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Furniture;
@Repository
public interface IFurnitureRepository extends JpaRepository<Furniture, Integer> {
	
	@Query("select u from Furniture u where u.titre like ?1% and u.price >=?2")
   List<Furniture>findByTitreAndPrice(String titre,int price);
	@Query("select u from Furniture u where u.state=true")
	List<Furniture>findBystate();
	@Modifying
	@Query("update Furniture u set u.state = false where u.furniture_id = ?1")
	public void buyFurniture(int furniture_id);
}
