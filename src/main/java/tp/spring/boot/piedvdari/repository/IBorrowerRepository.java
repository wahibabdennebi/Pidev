package tp.spring.boot.piedvdari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Borrower;

@Repository
public interface IBorrowerRepository extends CrudRepository<Borrower, Integer> {

}
