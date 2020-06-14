package io.aladiex.temp.repository;

import io.aladiex.temp.entity.Wallet;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Wallet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
	Optional<Wallet> findByCustomer_IdAndCurrency_Symbol(Long id, String symbol);
}
