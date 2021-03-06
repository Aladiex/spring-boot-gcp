package io.aladiex.temp.service;

import io.aladiex.temp.entity.Customer;
import io.aladiex.temp.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Customer}.
 */
@Service
@Transactional
public class CustomerService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.CustomerService.class);

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Save a customer.
     *
     * @param customer the entity to save.
     * @return the persisted entity.
     */
    public Customer save(Customer customer) {
        log.debug("Request to save Customer : {}", customer);
        return customerRepository.save(customer);
    }

    /**
     * Get all the customers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Customer> findAll(Pageable pageable) {
        log.debug("Request to get all Customers");
        return customerRepository.findAll(pageable);
    }
    
    /**
     * Get all the customers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Customer> getAll() {
        log.debug("Request to get all Customers");
        return customerRepository.findAllByOrderByCreatedAtAsc();
    }
    
   
    
    /**
     * Get all the customers invested.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Customer> getAllByInvested() {
        log.debug("Request to get all Customers");
        return customerRepository.findAllByInvested(true);
    }


    /**
     * Get one customer by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Customer> findOne(Long id) {
        log.debug("Request to get Customer : {}", id);
        return customerRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public Boolean existsByEmail(String email) {
        log.debug("Request to get Customer : {}", email);
        return customerRepository.existsByEmail(email);
    }

    /**
     * Delete the customer by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);
        customerRepository.deleteById(id);
    }
}
