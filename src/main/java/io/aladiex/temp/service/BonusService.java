package io.aladiex.temp.service;

import io.aladiex.temp.entity.Activity;
import io.aladiex.temp.entity.Bonus;
import io.aladiex.temp.entity.LockItem;
import io.aladiex.temp.entity.Order;
import io.aladiex.temp.repository.ActivityRepository;
import io.aladiex.temp.repository.BonusRepository;
import io.aladiex.temp.repository.LockItemRepository;
import io.aladiex.temp.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Bonus}.
 */
@Service
@Transactional
public class BonusService {
    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.ActivityService.class);

    private final BonusRepository bonusRepository;

    public BonusService(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }

    /**
     * Save a order.
     *
     * @param order the entity to save.
     * @return the persisted entity.
     */
    public Bonus save(Bonus bonus) {
        log.debug("Request to save Order : {}", bonus);
        return bonusRepository.save(bonus);
    }
    
    
    /**
     * get locked amount at round
     *
     * @param int roundId, long assetId.
     * @return the persisted entity.
     */
    public BigDecimal getLockedBonusAmountAtRound(int roundId, long assetId) {
        return bonusRepository.findByAssetIdAndRound(assetId, roundId).get().getAmount();
    }
    
    /**
     * get locked amount by asset_id
     *
     * @param long assetId.
     * @return the amount locked of customer
     */
    public BigDecimal getLockedBonusAmount(long assetId) {
        return bonusRepository.getLockedAmountByAssetId(assetId).get();
    }
    
    

    /**
     * Get all the orders.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Bonus> findAll(Pageable pageable) {
        log.debug("Request to get all LockItems");
        return bonusRepository.findAll(pageable);
        
    }
    
   


    /**
     * Get one order by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Bonus findOne(Long id) {
        log.debug("Request to get Order : {}", id);
        return bonusRepository.findById(id).get();
    }
    
   

    /**
     * Delete the order by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete LockItem : {}", id);
        bonusRepository.deleteById(id);
    }
}
