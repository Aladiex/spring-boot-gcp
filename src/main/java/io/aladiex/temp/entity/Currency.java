package io.aladiex.temp.entity;

import io.aladiex.temp.entity.enumeration.Standard;
import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Currency.
 */
@Entity
@Table(name = "currency")

public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Standard type;

    @Column(name = "token")
    private Boolean token;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @OneToMany(mappedBy = "currency")

    private Set<io.aladiex.temp.entity.Wallet> wallets = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public io.aladiex.temp.entity.Currency address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public io.aladiex.temp.entity.Currency name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public io.aladiex.temp.entity.Currency symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Standard getType() {
        return type;
    }

    public io.aladiex.temp.entity.Currency type(Standard type) {
        this.type = type;
        return this;
    }

    public void setType(Standard type) {
        this.type = type;
    }

    public Boolean isToken() {
        return token;
    }

    public io.aladiex.temp.entity.Currency token(Boolean token) {
        this.token = token;
        return this;
    }

    public void setToken(Boolean token) {
        this.token = token;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Currency status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Currency createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Currency updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<io.aladiex.temp.entity.Wallet> getWallets() {
        return wallets;
    }

    public io.aladiex.temp.entity.Currency wallets(Set<io.aladiex.temp.entity.Wallet> wallets) {
        this.wallets = wallets;
        return this;
    }

    public io.aladiex.temp.entity.Currency addWallets(io.aladiex.temp.entity.Wallet wallet) {
        this.wallets.add(wallet);
        wallet.setCurrency(this);
        return this;
    }

    public io.aladiex.temp.entity.Currency removeWallets(io.aladiex.temp.entity.Wallet wallet) {
        this.wallets.remove(wallet);
        wallet.setCurrency(null);
        return this;
    }

    public void setWallets(Set<io.aladiex.temp.entity.Wallet> wallets) {
        this.wallets = wallets;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof io.aladiex.temp.entity.Currency)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Currency) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Currency{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", name='" + getName() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", type='" + getType() + "'" +
            ", token='" + isToken() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
