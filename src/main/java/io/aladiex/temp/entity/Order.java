package io.aladiex.temp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.aladiex.temp.entity.enumeration.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * An Order.
 */
@Entity
@Table(name = "jhi_order")

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", precision = 21, scale = 2)
    private BigDecimal amount;

    @Column(name = "slot")
    private Integer slot;

    @Column(name = "fee")
    private BigDecimal fee;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "usdtHash")
    private String usdtHash;

    @Column(name = "ethHash")
    private String ethHash;

    @Column(name = "tokenHash")
    private String tokenHash;

    @Column(name = "booking")
    private Boolean booking;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    private Round round;

    @ManyToOne
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    private Asset asset;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getUsdtHash() {
        return usdtHash;
    }

    public void setUsdtHash(String usdtHash) {
        this.usdtHash = usdtHash;
    }

    public String getEthHash() {
        return ethHash;
    }

    public void setEthHash(String ethHash) {
        this.ethHash = ethHash;
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    public Boolean getBooking() {
        return booking;
    }

    public void setBooking(Boolean booking) {
        this.booking = booking;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof io.aladiex.temp.entity.Order)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Order) o).id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", booking='" + getBooking() + "'" +
                ", amount=" + getAmount() +
                ", fee='" + getFee() + "'" +
                ", cost='" + getCost() + "'" +
                ", status='" + getStatus() + "'" +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                "}";
    }
}
