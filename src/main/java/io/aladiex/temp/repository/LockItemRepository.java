package io.aladiex.temp.repository;

import io.aladiex.temp.entity.LockItem;
import io.aladiex.temp.entity.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Order entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LockItemRepository extends JpaRepository<LockItem, Long> {
	Optional<LockItem> findByAssetIdAndRound(Long assetId, int round);
	
	@Query("SELECT sum(t.amount) FROM LockItem t where t.assetId = :id")
	Optional<BigDecimal> getLockedAmountByAssetId(@Param("id") Long id);
}
