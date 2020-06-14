package io.aladiex.temp.repository;

import io.aladiex.temp.entity.Order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Order entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findOrdersByOwnerId(Long ownerId);

	Order findOneById(Long id);
}
