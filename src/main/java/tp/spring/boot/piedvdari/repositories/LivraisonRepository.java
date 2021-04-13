package tp.spring.boot.piedvdari.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Livreurs;

@Repository
public interface LivraisonRepository extends CrudRepository<Livreurs, Integer> {

}
