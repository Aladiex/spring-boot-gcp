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
 * A Wallet.
 */
@Entity
@Table(name = "wallet")

public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_key")
    private String key;

    @Column(name = "secret")
    private String secret;

    @Column(name = "balance", precision = 21, scale = 2)
    private BigDecimal balance;

    @Column(name = "frozen", precision = 21, scale = 2)
    private BigDecimal frozen;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @OneToMany(mappedBy = "wallet")

    private Set<io.aladiex.temp.entity.Transaction> transactions = new HashSet<>();

    @OneToMany(mappedBy = "wallet")

    private Set<io.aladiex.temp.entity.Commission> commissions = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "wallets", allowSetters = true)
    private io.aladiex.temp.entity.Customer customer;

    @ManyToOne
    @JsonIgnoreProperties(value = "wallets", allowSetters = true)
    private Currency currency;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public io.aladiex.temp.entity.Wallet key(String key) {
        this.key = key;
        return this;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public io.aladiex.temp.entity.Wallet secret(String secret) {
        this.secret = secret;
        return this;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public io.aladiex.temp.entity.Wallet balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFrozen() {
        return frozen;
    }

    public io.aladiex.temp.entity.Wallet frozen(BigDecimal frozen) {
        this.frozen = frozen;
        return this;
    }

    public void setFrozen(BigDecimal frozen) {
        this.frozen = frozen;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Wallet status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Wallet createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Wallet updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<io.aladiex.temp.entity.Transaction> getTransactions() {
        return transactions;
    }

    public io.aladiex.temp.entity.Wallet transactions(Set<io.aladiex.temp.entity.Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public io.aladiex.temp.entity.Wallet addTransactions(io.aladiex.temp.entity.Transaction transaction) {
        this.transactions.add(transaction);
        transaction.setWallet(this);
        return this;
    }

    public io.aladiex.temp.entity.Wallet removeTransactions(io.aladiex.temp.entity.Transaction transaction) {
        this.transactions.remove(transaction);
        transaction.setWallet(null);
        return this;
    }

    public void setTransactions(Set<io.aladiex.temp.entity.Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<io.aladiex.temp.entity.Commission> getCommissions() {
        return commissions;
    }

    public io.aladiex.temp.entity.Wallet commissions(Set<io.aladiex.temp.entity.Commission> commissions) {
        this.commissions = commissions;
        return this;
    }

    public io.aladiex.temp.entity.Wallet addCommissions(io.aladiex.temp.entity.Commission commission) {
        this.commissions.add(commission);
        commission.setWallet(this);
        return this;
    }

    public io.aladiex.temp.entity.Wallet removeCommissions(io.aladiex.temp.entity.Commission commission) {
        this.commissions.remove(commission);
        commission.setWallet(null);
        return this;
    }

    public void setCommissions(Set<io.aladiex.temp.entity.Commission> commissions) {
        this.commissions = commissions;
    }

    public io.aladiex.temp.entity.Customer getCustomer() {
        return customer;
    }

    public io.aladiex.temp.entity.Wallet customer(io.aladiex.temp.entity.Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(io.aladiex.temp.entity.Customer customer) {
        this.customer = customer;
    }

    public Currency getCurrency() {
        return currency;
    }

    public io.aladiex.temp.entity.Wallet currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof io.aladiex.temp.entity.Wallet)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Wallet) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Wallet{" +
            "id=" + getId() +
            ", key='" + getKey() + "'" +
            ", secret='" + getSecret() + "'" +
            ", balance=" + getBalance() +
            ", frozen=" + getFrozen() +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
