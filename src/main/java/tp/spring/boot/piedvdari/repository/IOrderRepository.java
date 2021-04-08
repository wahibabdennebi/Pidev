package tp.spring.boot.piedvdari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tp.spring.boot.piedvdari.entities.Order;

public interface IOrderRepository extends JpaRepository<Order,Integer> {

}
