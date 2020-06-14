package io.aladiex.temp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.aladiex.temp.entity.enumeration.Standard;
import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A Round.
 */
@Entity
@Table(name = "round")

public class Round implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capital", precision = 21, scale = 2)
    private BigDecimal capital;

    @Column(name = "total", precision = 21, scale = 2)
    private BigDecimal total;

    @Column(name = "jhi_left", precision = 21, scale = 2)
    private BigDecimal left;

    @Column(name = "fee", precision = 21, scale = 2)
    private BigDecimal fee;

    @Column(name = "slot")
    private Integer slot;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price", precision = 21, scale = 2)
    private BigDecimal price;

    @Column(name = "token_price", precision = 21, scale = 2)
    private BigDecimal tokenPrice;

    @Column(name = "reward", precision = 21, scale = 2)
    private BigDecimal reward;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Standard type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @OneToMany(mappedBy = "round")

    private Set<io.aladiex.temp.entity.Transfer> transfers = new HashSet<>();

    @OneToMany(mappedBy = "round")

    private Set<Unfreeze> unfreezes = new HashSet<>();

    @OneToMany(mappedBy = "round")

    private Set<io.aladiex.temp.entity.Order> orders = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "rounds", allowSetters = true)
    private Project project;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public io.aladiex.temp.entity.Round name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public io.aladiex.temp.entity.Round capital(BigDecimal capital) {
        this.capital = capital;
        return this;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public io.aladiex.temp.entity.Round total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getLeft() {
        return left;
    }

    public io.aladiex.temp.entity.Round left(BigDecimal left) {
        this.left = left;
        return this;
    }

    public void setLeft(BigDecimal left) {
        this.left = left;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public io.aladiex.temp.entity.Round fee(BigDecimal fee) {
        this.fee = fee;
        return this;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getSlot() {
        return slot;
    }

    public io.aladiex.temp.entity.Round slot(Integer slot) {
        this.slot = slot;
        return this;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Integer getStock() {
        return stock;
    }

    public io.aladiex.temp.entity.Round stock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public io.aladiex.temp.entity.Round price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTokenPrice() {
        return tokenPrice;
    }

    public io.aladiex.temp.entity.Round tokenPrice(BigDecimal tokenPrice) {
        this.tokenPrice = tokenPrice;
        return this;
    }

    public void setTokenPrice(BigDecimal tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public io.aladiex.temp.entity.Round reward(BigDecimal reward) {
        this.reward = reward;
        return this;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public Standard getType() {
        return type;
    }

    public io.aladiex.temp.entity.Round type(Standard type) {
        this.type = type;
        return this;
    }

    public void setType(Standard type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Round status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Round createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Round updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<io.aladiex.temp.entity.Transfer> getTransfers() {
        return transfers;
    }

    public io.aladiex.temp.entity.Round transfers(Set<io.aladiex.temp.entity.Transfer> transfers) {
        this.transfers = transfers;
        return this;
    }

    public io.aladiex.temp.entity.Round addTransfers(io.aladiex.temp.entity.Transfer transfer) {
        this.transfers.add(transfer);
        transfer.setRound(this);
        return this;
    }

    public io.aladiex.temp.entity.Round removeTransfers(io.aladiex.temp.entity.Transfer transfer) {
        this.transfers.remove(transfer);
        transfer.setRound(null);
        return this;
    }

    public void setTransfers(Set<io.aladiex.temp.entity.Transfer> transfers) {
        this.transfers = transfers;
    }

    public Set<Unfreeze> getUnfreezes() {
        return unfreezes;
    }

    public io.aladiex.temp.entity.Round unfreezes(Set<Unfreeze> unfreezes) {
        this.unfreezes = unfreezes;
        return this;
    }

    public io.aladiex.temp.entity.Round addUnfreezes(Unfreeze unfreeze) {
        this.unfreezes.add(unfreeze);
        unfreeze.setRound(this);
        return this;
    }

    public io.aladiex.temp.entity.Round removeUnfreezes(Unfreeze unfreeze) {
        this.unfreezes.remove(unfreeze);
        unfreeze.setRound(null);
        return this;
    }

    public void setUnfreezes(Set<Unfreeze> unfreezes) {
        this.unfreezes = unfreezes;
    }

    public Project getProject() {
        return project;
    }

    public io.aladiex.temp.entity.Round project(Project project) {
        this.project = project;
        return this;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof io.aladiex.temp.entity.Round)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Round) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Round{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", capital=" + getCapital() +
            ", total=" + getTotal() +
            ", left=" + getLeft() +
            ", fee=" + getFee() +
            ", slot=" + getSlot() +
            ", stock=" + getStock() +
            ", price=" + getPrice() +
            ", tokenPrice=" + getTokenPrice() +
            ", reward=" + getReward() +
            ", type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
