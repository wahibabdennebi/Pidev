package tp.spring.boot.piedvdari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
