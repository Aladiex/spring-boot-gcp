package io.aladiex.temp.service;

import io.aladiex.temp.entity.Unfreeze;
import io.aladiex.temp.repository.UnfreezeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Unfreeze}.
 */
@Service
@Transactional
public class UnfreezeService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.UnfreezeService.class);

    private final UnfreezeRepository unfreezeRepository;

    public UnfreezeService(UnfreezeRepository unfreezeRepository) {
        this.unfreezeRepository = unfreezeRepository;
    }

    /**
     * Save a unfreeze.
     *
     * @param unfreeze the entity to save.
     * @return the persisted entity.
     */
    public Unfreeze save(Unfreeze unfreeze) {
        log.debug("Request to save Unfreeze : {}", unfreeze);
        return unfreezeRepository.save(unfreeze);
    }

    /**
     * Get all the unfreezes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Unfreeze> findAll(Pageable pageable) {
        log.debug("Request to get all Unfreezes");
        return unfreezeRepository.findAll(pageable);
    }


    /**
     * Get one unfreeze by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Unfreeze> findOne(Long id) {
        log.debug("Request to get Unfreeze : {}", id);
        return unfreezeRepository.findById(id);
    }

    /**
     * Delete the unfreeze by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Unfreeze : {}", id);
        unfreezeRepository.deleteById(id);
    }
}
