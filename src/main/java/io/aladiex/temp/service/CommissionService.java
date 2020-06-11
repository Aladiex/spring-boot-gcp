package io.aladiex.temp.service;

import io.aladiex.temp.entity.Commission;
import io.aladiex.temp.repository.CommissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Commission}.
 */
@Service
@Transactional
public class CommissionService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.CommissionService.class);

    private final CommissionRepository commissionRepository;

    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    /**
     * Save a commission.
     *
     * @param commission the entity to save.
     * @return the persisted entity.
     */
    public Commission save(Commission commission) {
        log.debug("Request to save Commission : {}", commission);
        return commissionRepository.save(commission);
    }

    /**
     * Get all the commissions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Commission> findAll(Pageable pageable) {
        log.debug("Request to get all Commissions");
        return commissionRepository.findAll(pageable);
    }


    /**
     * Get one commission by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Commission> findOne(Long id) {
        log.debug("Request to get Commission : {}", id);
        return commissionRepository.findById(id);
    }

    /**
     * Delete the commission by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Commission : {}", id);
        commissionRepository.deleteById(id);
    }
}
