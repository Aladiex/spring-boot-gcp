package io.aladiex.temp.service;

import io.aladiex.temp.entity.Transfer;
import io.aladiex.temp.repository.TransferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Transfer}.
 */
@Service
@Transactional
public class TransferService {

    private final Logger log = LoggerFactory.getLogger(io.aladiex.temp.service.TransferService.class);

    private final TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    /**
     * Save a transfer.
     *
     * @param transfer the entity to save.
     * @return the persisted entity.
     */
    public Transfer save(Transfer transfer) {
        log.debug("Request to save Transfer : {}", transfer);
        return transferRepository.save(transfer);
    }

    /**
     * Get all the transfers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Transfer> findAll(Pageable pageable) {
        log.debug("Request to get all Transfers");
        return transferRepository.findAll(pageable);
    }


    /**
     * Get one transfer by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Transfer> findOne(Long id) {
        log.debug("Request to get Transfer : {}", id);
        return transferRepository.findById(id);
    }

    /**
     * Delete the transfer by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Transfer : {}", id);
        transferRepository.deleteById(id);
    }
}
