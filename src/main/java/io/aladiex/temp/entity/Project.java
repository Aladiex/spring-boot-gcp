package io.aladiex.temp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Project.
 */
@Entity
@Table(name = "project")

public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @OneToOne
    @JoinColumn(unique = true)
    private io.aladiex.temp.entity.Config config;

    @ManyToOne
    @JsonIgnoreProperties(value = "projects", allowSetters = true)
    private Customer owner;

    @OneToMany(mappedBy = "project")

    private Set<io.aladiex.temp.entity.Revenue> revenues = new HashSet<>();

    @OneToMany(mappedBy = "project")

    private Set<io.aladiex.temp.entity.Title> titles = new HashSet<>();

    @OneToMany(mappedBy = "project")

    private Set<io.aladiex.temp.entity.Contract> contracts = new HashSet<>();

    @OneToMany(mappedBy = "project")

    private Set<io.aladiex.temp.entity.Round> rounds = new HashSet<>();

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

    public io.aladiex.temp.entity.Project name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public io.aladiex.temp.entity.Project description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Project status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Project createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Project updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public io.aladiex.temp.entity.Config getConfig() {
        return config;
    }

    public io.aladiex.temp.entity.Project config(io.aladiex.temp.entity.Config config) {
        this.config = config;
        return this;
    }

    public void setConfig(io.aladiex.temp.entity.Config config) {
        this.config = config;
    }

    public Set<io.aladiex.temp.entity.Revenue> getRevenues() {
        return revenues;
    }

    public io.aladiex.temp.entity.Project revenues(Set<io.aladiex.temp.entity.Revenue> revenues) {
        this.revenues = revenues;
        return this;
    }

    public io.aladiex.temp.entity.Project addRevenues(io.aladiex.temp.entity.Revenue revenue) {
        this.revenues.add(revenue);
        revenue.setProject(this);
        return this;
    }

    public io.aladiex.temp.entity.Project removeRevenues(io.aladiex.temp.entity.Revenue revenue) {
        this.revenues.remove(revenue);
        revenue.setProject(null);
        return this;
    }

    public void setRevenues(Set<io.aladiex.temp.entity.Revenue> revenues) {
        this.revenues = revenues;
    }

    public Set<io.aladiex.temp.entity.Title> getTitles() {
        return titles;
    }

    public io.aladiex.temp.entity.Project titles(Set<io.aladiex.temp.entity.Title> titles) {
        this.titles = titles;
        return this;
    }

    public io.aladiex.temp.entity.Project addTitles(io.aladiex.temp.entity.Title title) {
        this.titles.add(title);
        title.setProject(this);
        return this;
    }

    public io.aladiex.temp.entity.Project removeTitles(io.aladiex.temp.entity.Title title) {
        this.titles.remove(title);
        title.setProject(null);
        return this;
    }

    public void setTitles(Set<io.aladiex.temp.entity.Title> titles) {
        this.titles = titles;
    }

    public Set<io.aladiex.temp.entity.Contract> getContracts() {
        return contracts;
    }

    public io.aladiex.temp.entity.Project contracts(Set<io.aladiex.temp.entity.Contract> contracts) {
        this.contracts = contracts;
        return this;
    }

    public io.aladiex.temp.entity.Project addContracts(io.aladiex.temp.entity.Contract contract) {
        this.contracts.add(contract);
        contract.setProject(this);
        return this;
    }

    public io.aladiex.temp.entity.Project removeContracts(io.aladiex.temp.entity.Contract contract) {
        this.contracts.remove(contract);
        contract.setProject(null);
        return this;
    }

    public void setContracts(Set<io.aladiex.temp.entity.Contract> contracts) {
        this.contracts = contracts;
    }

    public Set<io.aladiex.temp.entity.Round> getRounds() {
        return rounds;
    }

    public io.aladiex.temp.entity.Project rounds(Set<io.aladiex.temp.entity.Round> rounds) {
        this.rounds = rounds;
        return this;
    }

    public io.aladiex.temp.entity.Project addRounds(io.aladiex.temp.entity.Round round) {
        this.rounds.add(round);
        round.setProject(this);
        return this;
    }

    public io.aladiex.temp.entity.Project removeRounds(io.aladiex.temp.entity.Round round) {
        this.rounds.remove(round);
        round.setProject(null);
        return this;
    }

    public void setRounds(Set<io.aladiex.temp.entity.Round> rounds) {
        this.rounds = rounds;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof io.aladiex.temp.entity.Project)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Project) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Project{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
