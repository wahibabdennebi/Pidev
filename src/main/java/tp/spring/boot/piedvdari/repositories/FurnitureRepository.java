package tp.spring.boot.piedvdari.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Furniture;


@Repository
public interface FurnitureRepository extends CrudRepository<Furniture, Integer> {

}
