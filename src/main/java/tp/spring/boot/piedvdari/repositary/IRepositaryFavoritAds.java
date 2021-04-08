package tp.spring.boot.piedvdari.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Ads;
import tp.spring.boot.piedvdari.entities.Favorite_Ads;
import tp.spring.boot.piedvdari.entities.User;

@Repository
public interface IRepositaryFavoritAds extends JpaRepository<Favorite_Ads, Integer> {
	@Query("select f from Favorite_Ads f where f.user=?1 and f.ad=?2 and f.states=true")
	List<Favorite_Ads> findByUser_idAndAd_idAndStates( User user,Ads ad);
	

}
