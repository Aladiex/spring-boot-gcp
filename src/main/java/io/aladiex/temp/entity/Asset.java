package io.aladiex.temp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A Asset.
 */
@Entity
@Table(name = "asset")

public class Asset implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", precision = 21, scale = 2)
    private BigDecimal balance;

    @Column(name = "frozen", precision = 21, scale = 2)
    private BigDecimal frozen;

    @Column(name = "jhi_release", precision = 21, scale = 2)
    private BigDecimal release;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @OneToMany(mappedBy = "asset")

    private Set<io.aladiex.temp.entity.Transfer> transfers = new HashSet<>();

    @OneToMany(mappedBy = "asset")

    private Set<io.aladiex.temp.entity.Unfreeze> unfreezes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "assets", allowSetters = true)
    private io.aladiex.temp.entity.Customer customer;

    @ManyToOne
    @JsonIgnoreProperties(value = "assets", allowSetters = true)
    private io.aladiex.temp.entity.Contract contract;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public io.aladiex.temp.entity.Asset balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFrozen() {
        return frozen;
    }

    public io.aladiex.temp.entity.Asset frozen(BigDecimal frozen) {
        this.frozen = frozen;
        return this;
    }

    public void setFrozen(BigDecimal frozen) {
        this.frozen = frozen;
    }

    public BigDecimal getRelease() {
        return release;
    }

    public io.aladiex.temp.entity.Asset release(BigDecimal release) {
        this.release = release;
        return this;
    }

    public void setRelease(BigDecimal release) {
        this.release = release;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Asset status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Asset createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Asset updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<io.aladiex.temp.entity.Transfer> getTransfers() {
        return transfers;
    }

    public io.aladiex.temp.entity.Asset transfers(Set<io.aladiex.temp.entity.Transfer> transfers) {
        this.transfers = transfers;
        return this;
    }

    public io.aladiex.temp.entity.Asset addTransfers(io.aladiex.temp.entity.Transfer transfer) {
        this.transfers.add(transfer);
        transfer.setAsset(this);
        return this;
    }

    public io.aladiex.temp.entity.Asset removeTransfers(io.aladiex.temp.entity.Transfer transfer) {
        this.transfers.remove(transfer);
        transfer.setAsset(null);
        return this;
    }

    public void setTransfers(Set<io.aladiex.temp.entity.Transfer> transfers) {
        this.transfers = transfers;
    }

    public Set<io.aladiex.temp.entity.Unfreeze> getUnfreezes() {
        return unfreezes;
    }

    public io.aladiex.temp.entity.Asset unfreezes(Set<io.aladiex.temp.entity.Unfreeze> unfreezes) {
        this.unfreezes = unfreezes;
        return this;
    }

    public io.aladiex.temp.entity.Asset addUnfreezes(io.aladiex.temp.entity.Unfreeze unfreeze) {
        this.unfreezes.add(unfreeze);
        unfreeze.setAsset(this);
        return this;
    }

    public io.aladiex.temp.entity.Asset removeUnfreezes(io.aladiex.temp.entity.Unfreeze unfreeze) {
        this.unfreezes.remove(unfreeze);
        unfreeze.setAsset(null);
        return this;
    }

    public void setUnfreezes(Set<io.aladiex.temp.entity.Unfreeze> unfreezes) {
        this.unfreezes = unfreezes;
    }

    public io.aladiex.temp.entity.Customer getCustomer() {
        return customer;
    }

    public io.aladiex.temp.entity.Asset customer(io.aladiex.temp.entity.Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(io.aladiex.temp.entity.Customer customer) {
        this.customer = customer;
    }

    public io.aladiex.temp.entity.Contract getContract() {
        return contract;
    }

    public io.aladiex.temp.entity.Asset contract(io.aladiex.temp.entity.Contract contract) {
        this.contract = contract;
        return this;
    }

    public void setContract(io.aladiex.temp.entity.Contract contract) {
        this.contract = contract;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof io.aladiex.temp.entity.Asset)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Asset) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Asset{" +
            "id=" + getId() +
            ", balance=" + getBalance() +
            ", frozen=" + getFrozen() +
            ", release=" + getRelease() +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
