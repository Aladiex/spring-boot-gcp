package io.aladiex.temp.entity;

import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A RateLock.
 */
public class RateLock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = "rateLocks", allowSetters = true)
    private Project project;

    @Column(name = "roundAt")
    private int roundAt;

    @Column(name = "roundName")
    private String roundName;
    
/*
 * example:
   	Founder 12-58(1,7) 59(1,4)
    rate is json object: Rate:{1:100;2:100;.....12:98.3;13:96.6;.....69:3.1;70:1.4}
  */
    @Column(name = "rate")
    private String rate;

    @Column(name = "token")
    private BigDecimal token;

    @Column(name = "bonus")
    private BigDecimal bonus;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getRoundAt() {
		return roundAt;
	}

	public void setRoundAt(int roundAt) {
		this.roundAt = roundAt;
	}

	public String getRoundName() {
		return roundName;
	}

	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public BigDecimal getToken() {
		return token;
	}

	public void setToken(BigDecimal token) {
		this.token = token;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}



    // prettier-ignore
    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
//            ", firstName='" + getFirstName() + "'" +
//            ", lastName='" + getLastName() + "'" +
            "}";
    }
}
