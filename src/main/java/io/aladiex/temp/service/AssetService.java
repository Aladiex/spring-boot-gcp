package io.aladiex.temp.service;

import io.aladiex.temp.entity.Asset;
import io.aladiex.temp.repository.AssetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Asset}.
 */
@Service
@Transactional
public class AssetService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.AssetService.class);

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    /**
     * Save a asset.
     *
     * @param asset the entity to save.
     * @return the persisted entity.
     */
    public Asset save(Asset asset) {
        log.debug("Request to save Asset : {}", asset);
        return assetRepository.save(asset);
    }

    /**
     * Get all the assets.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Asset> findAll(Pageable pageable) {
        log.debug("Request to get all Assets");
        return assetRepository.findAll(pageable);
    }


    /**
     * Get one asset by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Asset> findOne(Long id) {
        log.debug("Request to get Asset : {}", id);
        return assetRepository.findById(id);
    }

    /**
     * Delete the asset by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Asset : {}", id);
        assetRepository.deleteById(id);
    }
}
