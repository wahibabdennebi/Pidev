package tp.spring.boot.piedvdari.service;

import java.util.List;

import tp.spring.boot.piedvdari.entities.Favorite_Ads;

public interface IFavoriteService {
	public void ajouterFavorite(Favorite_Ads f);
	public List<Favorite_Ads> FindallFavorite();
	public void deleteFavAd(int d);
	public void UpdateFavorite(int IdFav,Favorite_Ads f);

}
