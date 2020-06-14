package io.aladiex.temp.repository;

import io.aladiex.temp.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Currency entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	
}
