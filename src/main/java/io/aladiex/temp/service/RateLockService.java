package io.aladiex.temp.service;

import io.aladiex.temp.entity.Customer;
import io.aladiex.temp.entity.RateLock;
import io.aladiex.temp.repository.RateLockRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link RateLock}.
 */
@Service
@Transactional
public class RateLockService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.RateLockService.class);

    private final RateLockRepository rateLockRepository;

    public RateLockService(RateLockRepository rateLockRepository) {
        this.rateLockRepository = rateLockRepository;
    }

    /**
     * Save a rateLock.
     *
     * @param rateLock the entity to save.
     * @return the persisted entity.
     */
    public RateLock save(RateLock rateLock) {
        log.debug("Request to save RateLock : {}", rateLock);
        return rateLockRepository.save(rateLock);
    }

    /**
     * Get all the rateLocks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<RateLock> findAll() {
        log.debug("Request to get all RateLocks");
        return rateLockRepository.findAll();
    }
    
   
    /**
     * Get the rateLock by project id and round at.
     *
     * @param long projectId and int roundAt.
     * @return the RateLock.
     */
    public Optional<RateLock> getRateLockByProjIdAndRoundAt(Long projId, int roundAt)
    {
    	return rateLockRepository.findByProject_IdAndRoundAt(projId, roundAt);
    }

    /**
     * Delete the customer by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete RateLock : {}", id);
        rateLockRepository.deleteById(id);
    }
}
