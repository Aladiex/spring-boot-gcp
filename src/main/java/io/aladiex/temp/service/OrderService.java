package io.aladiex.temp.service;

import io.aladiex.temp.entity.Activity;
import io.aladiex.temp.entity.Order;
import io.aladiex.temp.repository.ActivityRepository;
import io.aladiex.temp.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Order}.
 */
@Service
@Transactional
public class OrderService {
    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.ActivityService.class);

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Save a order.
     *
     * @param order the entity to save.
     * @return the persisted entity.
     */
    public Order save(Order order) {
        log.debug("Request to save Order : {}", order);
        return orderRepository.save(order);
    }
    
    

    /**
     * Get all the orders.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Order> findAll(Pageable pageable) {
        log.debug("Request to get all Orders");
        return orderRepository.findAll(pageable);
    }
    
    /**
     * Get the orders by owner
     *
     * @param ownerId
     * @return the list of orderss.
     */
    @Transactional(readOnly = true)
    public List<Order> findOrdersByOwnerId(Long ownerId) {
        log.debug("Request to get all Orders");
        return orderRepository.findOrdersByOwnerId(ownerId);
    }



    /**
     * Get one order by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Order> findOne(Long id) {
        log.debug("Request to get Order : {}", id);
        return orderRepository.findById(id);
    }
    
    /**
     * Get one order by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Order findOneByOrderId(Long id) {
        log.debug("Request to get Order : {}", id);
        return orderRepository.findOneById(id);
    }

    /**
     * Delete the order by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Order : {}", id);
        orderRepository.deleteById(id);
    }
}
