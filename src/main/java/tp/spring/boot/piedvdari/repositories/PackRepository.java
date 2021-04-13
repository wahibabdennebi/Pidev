package tp.spring.boot.piedvdari.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Pack;
@Repository
public interface PackRepository extends CrudRepository<Pack, Integer> {
	

}
