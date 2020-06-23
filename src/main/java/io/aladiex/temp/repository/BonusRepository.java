package io.aladiex.temp.repository;

import io.aladiex.temp.entity.Bonus;
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
public interface BonusRepository extends JpaRepository<Bonus, Long> {
	Optional<Bonus> findByAssetIdAndRound(Long assetId, int round);
	
	@Query("SELECT sum(t.amount) FROM Bonus t where t.assetId = :id")
	Optional<BigDecimal> getLockedAmountByAssetId(@Param("id") Long id);
}
