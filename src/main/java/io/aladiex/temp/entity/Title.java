package io.aladiex.temp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A Title.
 */
@Entity
@Table(name = "title")

public class Title implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "fund", precision = 21, scale = 2)
    private BigDecimal fund;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = "titles", allowSetters = true)
    private io.aladiex.temp.entity.Customer customer;

    @ManyToOne
    @JsonIgnoreProperties(value = "titles", allowSetters = true)
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

    public io.aladiex.temp.entity.Title name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getFund() {
        return fund;
    }

    public io.aladiex.temp.entity.Title fund(BigDecimal fund) {
        this.fund = fund;
        return this;
    }

    public void setFund(BigDecimal fund) {
        this.fund = fund;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Title status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Title createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Title updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public io.aladiex.temp.entity.Customer getCustomer() {
        return customer;
    }

    public io.aladiex.temp.entity.Title customer(io.aladiex.temp.entity.Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(io.aladiex.temp.entity.Customer customer) {
        this.customer = customer;
    }

    public Project getProject() {
        return project;
    }

    public io.aladiex.temp.entity.Title project(Project project) {
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
        if (!(o instanceof io.aladiex.temp.entity.Title)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Title) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Title{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", fund=" + getFund() +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
