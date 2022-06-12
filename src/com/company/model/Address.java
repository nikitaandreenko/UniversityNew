package com.company.model;

public class Address {
    private String sity;
    private String street;
    private int house;
    private int flat;

    public Address(String sity, String street, int house, int flat) {
        this.sity = sity;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "sity='" + sity + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", flat=" + flat +
                '}';
    }
}
