package io.aladiex.temp.entity;

import io.aladiex.temp.entity.enumeration.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "cor")
    private String cor;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "zip")
    private String zip;

    @Column(name = "telegram")
    private String telegram;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "kyc_verified")
    private Boolean kycVerified;

    @Column(name = "sponsor_code")
    private String sponsorCode;

    @Column(name = "origin")
    private String origin;

    @Column(name = "sponsor")
    private String sponsor;

    @Column(name = "secret")
    private String secret;
    
    @Column(name = "sale")
    private int sale;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "updated_at")
    private Long updatedAt;

    @OneToMany(mappedBy = "customer")

    private Set<Wallet> wallets = new HashSet<>();

    @OneToMany(mappedBy = "customer")

    private Set<Asset> assets = new HashSet<>();

    @OneToMany(mappedBy = "customer")

    private Set<Activity> activities = new HashSet<>();

    @OneToMany(mappedBy = "customer")

    private Set<io.aladiex.temp.entity.Revenue> revenues = new HashSet<>();

    @OneToMany(mappedBy = "customer")

    private Set<Title> titles = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public io.aladiex.temp.entity.Customer firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getLastName() {
        return lastName;
    }

    public io.aladiex.temp.entity.Customer lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public io.aladiex.temp.entity.Customer addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public io.aladiex.temp.entity.Customer addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCor() {
        return cor;
    }

    public io.aladiex.temp.entity.Customer cor(String cor) {
        this.cor = cor;
        return this;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPhone() {
        return phone;
    }

    public io.aladiex.temp.entity.Customer phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public io.aladiex.temp.entity.Customer email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public io.aladiex.temp.entity.Customer nationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getZip() {
        return zip;
    }

    public io.aladiex.temp.entity.Customer zip(String zip) {
        this.zip = zip;
        return this;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelegram() {
        return telegram;
    }

    public io.aladiex.temp.entity.Customer telegram(String telegram) {
        this.telegram = telegram;
        return this;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getDob() {
        return dob;
    }

    public io.aladiex.temp.entity.Customer dob(String dob) {
        this.dob = dob;
        return this;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Boolean isEmailVerified() {
        return emailVerified;
    }

    public io.aladiex.temp.entity.Customer emailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
        return this;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Boolean isKycVerified() {
        return kycVerified;
    }

    public io.aladiex.temp.entity.Customer kycVerified(Boolean kycVerified) {
        this.kycVerified = kycVerified;
        return this;
    }

    public void setKycVerified(Boolean kycVerified) {
        this.kycVerified = kycVerified;
    }

    public String getSponsorCode() {
        return sponsorCode;
    }

    public io.aladiex.temp.entity.Customer sponsorCode(String sponsorCode) {
        this.sponsorCode = sponsorCode;
        return this;
    }

    public void setSponsorCode(String sponsorCode) {
        this.sponsorCode = sponsorCode;
    }

    public String getOrigin() {
        return origin;
    }

    public io.aladiex.temp.entity.Customer origin(String origin) {
        this.origin = origin;
        return this;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSponsor() {
        return sponsor;
    }

    public io.aladiex.temp.entity.Customer sponsor(String sponsor) {
        this.sponsor = sponsor;
        return this;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSecret() {
        return secret;
    }

    public io.aladiex.temp.entity.Customer secret(String secret) {
        this.secret = secret;
        return this;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Status getStatus() {
        return status;
    }

    public io.aladiex.temp.entity.Customer status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public io.aladiex.temp.entity.Customer createdAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public io.aladiex.temp.entity.Customer updatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Wallet> getWallets() {
        return wallets;
    }

    public io.aladiex.temp.entity.Customer wallets(Set<Wallet> wallets) {
        this.wallets = wallets;
        return this;
    }

    public io.aladiex.temp.entity.Customer addWallets(Wallet wallet) {
        this.wallets.add(wallet);
        wallet.setCustomer(this);
        return this;
    }

    public io.aladiex.temp.entity.Customer removeWallets(Wallet wallet) {
        this.wallets.remove(wallet);
        wallet.setCustomer(null);
        return this;
    }

    public void setWallets(Set<Wallet> wallets) {
        this.wallets = wallets;
    }

    public Set<Asset> getAssets() {
        return assets;
    }

    public io.aladiex.temp.entity.Customer assets(Set<Asset> assets) {
        this.assets = assets;
        return this;
    }

    public io.aladiex.temp.entity.Customer addAssets(Asset asset) {
        this.assets.add(asset);
        asset.setCustomer(this);
        return this;
    }

    public io.aladiex.temp.entity.Customer removeAssets(Asset asset) {
        this.assets.remove(asset);
        asset.setCustomer(null);
        return this;
    }

    public void setAssets(Set<Asset> assets) {
        this.assets = assets;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public io.aladiex.temp.entity.Customer activities(Set<Activity> activities) {
        this.activities = activities;
        return this;
    }

    public io.aladiex.temp.entity.Customer addActivities(Activity activity) {
        this.activities.add(activity);
        activity.setCustomer(this);
        return this;
    }

    public io.aladiex.temp.entity.Customer removeActivities(Activity activity) {
        this.activities.remove(activity);
        activity.setCustomer(null);
        return this;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<io.aladiex.temp.entity.Revenue> getRevenues() {
        return revenues;
    }

    public io.aladiex.temp.entity.Customer revenues(Set<io.aladiex.temp.entity.Revenue> revenues) {
        this.revenues = revenues;
        return this;
    }

    public io.aladiex.temp.entity.Customer addRevenues(io.aladiex.temp.entity.Revenue revenue) {
        this.revenues.add(revenue);
        revenue.setCustomer(this);
        return this;
    }

    public io.aladiex.temp.entity.Customer removeRevenues(io.aladiex.temp.entity.Revenue revenue) {
        this.revenues.remove(revenue);
        revenue.setCustomer(null);
        return this;
    }

    public void setRevenues(Set<io.aladiex.temp.entity.Revenue> revenues) {
        this.revenues = revenues;
    }

    public Set<Title> getTitles() {
        return titles;
    }

    public io.aladiex.temp.entity.Customer titles(Set<Title> titles) {
        this.titles = titles;
        return this;
    }

    public io.aladiex.temp.entity.Customer addTitles(Title title) {
        this.titles.add(title);
        title.setCustomer(this);
        return this;
    }

    public io.aladiex.temp.entity.Customer removeTitles(Title title) {
        this.titles.remove(title);
        title.setCustomer(null);
        return this;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof io.aladiex.temp.entity.Customer)) {
            return false;
        }
        return id != null && id.equals(((io.aladiex.temp.entity.Customer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", addressLine1='" + getAddressLine1() + "'" +
            ", addressLine2='" + getAddressLine2() + "'" +
            ", cor='" + getCor() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", zip='" + getZip() + "'" +
            ", telegram='" + getTelegram() + "'" +
            ", dob='" + getDob() + "'" +
            ", emailVerified='" + isEmailVerified() + "'" +
            ", kycVerified='" + isKycVerified() + "'" +
            ", sponsorCode='" + getSponsorCode() + "'" +
            ", origin='" + getOrigin() + "'" +
            ", sponsor='" + getSponsor() + "'" +
            ", secret='" + getSecret() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt=" + getCreatedAt() +
            ", updatedAt=" + getUpdatedAt() +
            "}";
    }
}
