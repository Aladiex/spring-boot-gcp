package io.aladiex.temp.repository;

import io.aladiex.temp.entity.Unfreeze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Unfreeze entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UnfreezeRepository extends JpaRepository<Unfreeze, Long> {
}
