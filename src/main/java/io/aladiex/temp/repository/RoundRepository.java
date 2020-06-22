package io.aladiex.temp.repository;

import io.aladiex.temp.entity.Round;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Round entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {
	Optional<Round> findByProjectIdAndStatus(Long projectId, String status);
}
