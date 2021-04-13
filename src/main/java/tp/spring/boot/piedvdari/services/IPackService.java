package tp.spring.boot.piedvdari.services;

import java.util.Optional;

import tp.spring.boot.piedvdari.entities.Pack;

public interface IPackService {

	public void ajouterPack(Pack pack);

	public void supprimerPack(Pack pack);

	public Pack modiferPack(Pack pack);

	public Optional<Pack> id_pac(Pack pack);

	Optional<Pack> findPackById(int id);



}
