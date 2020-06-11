package io.aladiex.temp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A Revenue.
 */
@Entity
@Table(name = "revenue")

public class Revenue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_invest", precision = 21, scale = 2)
    private BigDecimal totalInvest;

    @Column(name = "total_issued", precision = 21, scale = 2)
    private BigDecimal totalIssued;

    @Column(name = "total_unfreeze", precision = 21, scale = 2)
    private BigDecimal totalUnfreeze;

    @Column(name = "total_commission", precision = 21, scale = 2)
    private BigDecimal totalCommission;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = "revenues", allowSetters = true)
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties(value = "revenues", allowSetters = true)
    private Project project;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalInvest() {
        return totalInvest;
    }

    public io.aladiex.temp.entity.Revenue totalInvest(BigDecimal totalInvest) {
        this.totalInvest = totalInvest;
        return this;
    }

    public void setTotalInvest(BigDecimal totalInvest) {
        this.totalInvest = totalInvest;
    }

    public BigDecimal getTotalIssued() {
        return totalIssued;
    }

    public io.aladiex.temp.entity.Revenue totalIssued(BigDecimal totalIssued) {
        this.totalIssued = totalIssued;
        return this;
    }

    public void setTotalIssued(BigDecimal totalIssued) {
        this.totalIssued = totalIssued;
    }

    public BigDecimal getTotalUnfreeze() {
        return totalUnfreeze;
    }

    public io.aladiex.temp.entity.Revenue totalUnfreeze(BigDecimal totalUnfreeze) {
        this.totalUnfreeze = totalUnfreeze;
        return this;
    }

    public void setTotalUnfreeze(BigDecimal totalUnfreeze) {
        this.totalUnfreeze = totalUnfreeze;
    }

    public BigDecimal getTotalCommission() {
        return totalCommission;
    }

    public io.aladiex.temp.entity.Revenue totalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
        return this;
    }

    public void setTotalCommission(BigDecimal totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Revenue status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Revenue createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Revenue updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public io.aladiex.temp.entity.Revenue customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Project getProject() {
        return project;
    }

    public io.aladiex.temp.entity.Revenue project(Project project) {
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
        if (!(o instanceof io.aladiex.temp.entity.Revenue)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Revenue) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Revenue{" +
            "id=" + getId() +
            ", totalInvest=" + getTotalInvest() +
            ", totalIssued=" + getTotalIssued() +
            ", totalUnfreeze=" + getTotalUnfreeze() +
            ", totalCommission=" + getTotalCommission() +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
