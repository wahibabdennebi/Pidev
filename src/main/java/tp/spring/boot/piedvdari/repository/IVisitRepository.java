package tp.spring.boot.piedvdari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Visit;

@Repository
public interface IVisitRepository extends CrudRepository<Visit, Integer> {

}
