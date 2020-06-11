package io.aladiex.temp.service;

import io.aladiex.temp.entity.Title;
import io.aladiex.temp.repository.TitleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Title}.
 */
@Service
@Transactional
public class TitleService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.TitleService.class);

    private final TitleRepository titleRepository;

    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    /**
     * Save a title.
     *
     * @param title the entity to save.
     * @return the persisted entity.
     */
    public Title save(Title title) {
        log.debug("Request to save Title : {}", title);
        return titleRepository.save(title);
    }

    /**
     * Get all the titles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Title> findAll(Pageable pageable) {
        log.debug("Request to get all Titles");
        return titleRepository.findAll(pageable);
    }


    /**
     * Get one title by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Title> findOne(Long id) {
        log.debug("Request to get Title : {}", id);
        return titleRepository.findById(id);
    }

    /**
     * Delete the title by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Title : {}", id);
        titleRepository.deleteById(id);
    }
}
