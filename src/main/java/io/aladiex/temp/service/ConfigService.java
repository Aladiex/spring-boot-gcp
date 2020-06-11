package io.aladiex.temp.service;

import io.aladiex.temp.entity.Config;
import io.aladiex.temp.repository.ConfigRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing {@link Config}.
 */
@Service
@Transactional
public class ConfigService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.ConfigService.class);

    private final ConfigRepository configRepository;

    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    /**
     * Save a config.
     *
     * @param config the entity to save.
     * @return the persisted entity.
     */
    public Config save(Config config) {
        log.debug("Request to save Config : {}", config);
        return configRepository.save(config);
    }

    /**
     * Get all the configs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Config> findAll(Pageable pageable) {
        log.debug("Request to get all Configs");
        return configRepository.findAll(pageable);
    }



    /**
     *  Get all the configs where Project is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true) 
    public List<Config> findAllWhereProjectIsNull() {
        log.debug("Request to get all configs where Project is null");
        return StreamSupport
            .stream(configRepository.findAll().spliterator(), false)
            .filter(config -> config.getProject() == null)
            .collect(Collectors.toList());
    }

    /**
     * Get one config by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Config> findOne(Long id) {
        log.debug("Request to get Config : {}", id);
        return configRepository.findById(id);
    }

    /**
     * Delete the config by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Config : {}", id);
        configRepository.deleteById(id);
    }
}
