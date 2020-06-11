package io.aladiex.temp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.aladiex.temp.entity.enumeration.Metadata;
import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Activity.
 */
@Entity
@Table(name = "activity")

public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "browser")
    private String browser;

    @Column(name = "ip")
    private String ip;

    @Column(name = "url")
    private String url;

    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "metadata")
    private Metadata metadata;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @ManyToOne
    @JsonIgnoreProperties(value = "activities", allowSetters = true)
    private io.aladiex.temp.entity.Customer customer;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrowser() {
        return browser;
    }

    public io.aladiex.temp.entity.Activity browser(String browser) {
        this.browser = browser;
        return this;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getIp() {
        return ip;
    }

    public io.aladiex.temp.entity.Activity ip(String ip) {
        this.ip = ip;
        return this;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public io.aladiex.temp.entity.Activity url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public io.aladiex.temp.entity.Activity content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public io.aladiex.temp.entity.Activity metadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Activity status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Activity createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Activity updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public io.aladiex.temp.entity.Customer getCustomer() {
        return customer;
    }

    public io.aladiex.temp.entity.Activity customer(io.aladiex.temp.entity.Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(io.aladiex.temp.entity.Customer customer) {
        this.customer = customer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof io.aladiex.temp.entity.Activity)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Activity) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Activity{" +
            "id=" + getId() +
            ", browser='" + getBrowser() + "'" +
            ", ip='" + getIp() + "'" +
            ", url='" + getUrl() + "'" +
            ", content='" + getContent() + "'" +
            ", metadata='" + getMetadata() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
