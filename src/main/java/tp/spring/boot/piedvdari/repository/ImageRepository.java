package tp.spring.boot.piedvdari.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import tp.spring.boot.piedvdari.entities.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long>{
	
	Optional<ImageModel> findByName(String name);

}
