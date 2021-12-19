package com.epam.studying.entity;

public class Address {

    private String zipCode;
    private String city;
    private String street;
    private Integer homeNumber;
    private Integer flatNumber;

    public Address(String zipCode, String city, String street, Integer homeNumber, Integer flatNumber) {
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.flatNumber = flatNumber;
    }

    public Address(String zipCode, String city) {
       this(zipCode, city, null, null, null);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(Integer homeNumber) {
        this.homeNumber = homeNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }
}
