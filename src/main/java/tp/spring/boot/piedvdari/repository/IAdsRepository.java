package tp.spring.boot.piedvdari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.spring.boot.piedvdari.entities.Ads;

public interface IAdsRepository extends JpaRepository<Ads, Integer> {

}
