package io.aladiex.temp.service;

import io.aladiex.temp.entity.Revenue;
import io.aladiex.temp.repository.RevenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Revenue}.
 */
@Service
@Transactional
public class RevenueService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.RevenueService.class);

    private final RevenueRepository revenueRepository;

    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    /**
     * Save a revenue.
     *
     * @param revenue the entity to save.
     * @return the persisted entity.
     */
    public Revenue save(Revenue revenue) {
        log.debug("Request to save Revenue : {}", revenue);
        return revenueRepository.save(revenue);
    }

    /**
     * Get all the revenues.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Revenue> findAll(Pageable pageable) {
        log.debug("Request to get all Revenues");
        return revenueRepository.findAll(pageable);
    }


    /**
     * Get one revenue by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Revenue> findOne(Long id) {
        log.debug("Request to get Revenue : {}", id);
        return revenueRepository.findById(id);
    }

    /**
     * Delete the revenue by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Revenue : {}", id);
        revenueRepository.deleteById(id);
    }
}
