package com.ms.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int addressId;

    @Column(name = "city")
    String cityName;

    @Column(name = "nation")
    String countryName;

  //!!! No Need to Mention the Address Side the Mapping with Parent
/*   @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
     User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public Address(int addressId, String cityName, String countryName) {
        this.addressId = addressId;
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
