package tp.spring.boot.piedvdari.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Assurance;

@Repository
public interface AssurancesRepository extends CrudRepository<Assurance, Integer> {

}
