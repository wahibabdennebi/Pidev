package tp.spring.boot.piedvdari.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tp.spring.boot.piedvdari.entities.User;

@Repository
public interface IRepsitaryUser extends JpaRepository<User, Integer> {

}
