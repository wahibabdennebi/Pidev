package tp.spring.boot.piedvdari.repositary;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Ads;
import tp.spring.boot.piedvdari.entities.Category;
import tp.spring.boot.piedvdari.entities.City;
import tp.spring.boot.piedvdari.entities.Type_ads;
import tp.spring.boot.piedvdari.entities.User;
@Repository
public interface IRepositary extends JpaRepository<Ads, Integer> {
	@Query("select x from Ads x where x.title like ?1% and category=?2 and city=?3 and type_ads=?4")
		List<Ads> findByTitleAndCategoryAndCity(String title,Category category,City city,Type_ads type_ads);

	

}
