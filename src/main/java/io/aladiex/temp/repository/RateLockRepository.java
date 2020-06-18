package io.aladiex.temp.repository;
import io.aladiex.temp.entity.Customer;
import io.aladiex.temp.entity.RateLock;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Customer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RateLockRepository extends JpaRepository<RateLock, Long> {
	Optional<RateLock> findByProject_IdAndRoundAt(Long projectId, int at);
}
