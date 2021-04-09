package tp.spring.boot.piedvdari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Bank;

@Repository
public interface IBankRepository extends CrudRepository<Bank, Integer> {

}
