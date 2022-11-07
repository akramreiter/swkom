package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.PostalCode;

import javax.persistence.Entity;
import javax.persistence.Id;

@PostalCode
@Entity
public class Recipient {
    private String name;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    @Id
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
