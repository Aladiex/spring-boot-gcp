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
 * A Contract.
 */
@Entity
@Table(name = "contract")

public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "total", precision = 21, scale = 2)
    private BigDecimal total;

    @Column(name = "jhi_decimal", precision = 21, scale = 2)
    private BigDecimal decimal;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

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

    @OneToMany(mappedBy = "contract")

    private Set<Asset> assets = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "contracts", allowSetters = true)
    private Project project;

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

    public io.aladiex.temp.entity.Contract address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public io.aladiex.temp.entity.Contract total(BigDecimal total) {
        this.total = total;
        return this;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public io.aladiex.temp.entity.Contract decimal(BigDecimal decimal) {
        this.decimal = decimal;
        return this;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

    public String getName() {
        return name;
    }

    public io.aladiex.temp.entity.Contract name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public io.aladiex.temp.entity.Contract symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Standard getType() {
        return type;
    }

    public io.aladiex.temp.entity.Contract type(Standard type) {
        this.type = type;
        return this;
    }

    public void setType(Standard type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Contract status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Contract createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Contract updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Asset> getAssets() {
        return assets;
    }

    public io.aladiex.temp.entity.Contract assets(Set<Asset> assets) {
        this.assets = assets;
        return this;
    }

    public io.aladiex.temp.entity.Contract addAssets(Asset asset) {
        this.assets.add(asset);
        asset.setContract(this);
        return this;
    }

    public io.aladiex.temp.entity.Contract removeAssets(Asset asset) {
        this.assets.remove(asset);
        asset.setContract(null);
        return this;
    }

    public void setAssets(Set<Asset> assets) {
        this.assets = assets;
    }

    public Project getProject() {
        return project;
    }

    public io.aladiex.temp.entity.Contract project(Project project) {
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
        if (!(o instanceof io.aladiex.temp.entity.Contract)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Contract) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Contract{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", total=" + getTotal() +
            ", decimal=" + getDecimal() +
            ", name='" + getName() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
