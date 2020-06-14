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
    
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "amount", precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "slot")
    private Integer slot;

    @Column(name = "nameToken")
    private String nameToken;
    
    @Column(name = "ethFee")
    private BigDecimal ethFee;
    
    @Column(name = "ethBonusFee")
    private BigDecimal ethBonusFee;

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

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    private long roundId;


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

    

    public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public String getNameToken() {
		return nameToken;
	}

	public void setNameToken(String nameToken) {
		this.nameToken = nameToken;
	}

	public BigDecimal getEthFee() {
		return ethFee;
	}

	public void setEthFee(BigDecimal ethFee) {
		this.ethFee = ethFee;
	}

	public BigDecimal getEthBonusFee() {
		return ethBonusFee;
	}

	public void setEthBonusFee(BigDecimal ethBonusFee) {
		this.ethBonusFee = ethBonusFee;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
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
                ", ethFee='" + getEthFee() + "'" +
                ", cost='" + getCost() + "'" +
                ", status='" + getStatus() + "'" +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                "}";
    }
}
