package com.example.countryapp;

import java.io.Serializable;

public class Country implements Serializable {

    private String country;
    private int iconFlag;
    private String capital;
    private int square;

    public Country(String country, int iconFlag, String capital, int square) {
        this.country = country;
        this.iconFlag = iconFlag;
        this.capital = capital;
        this.square = square;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getIconFlag() {
        return iconFlag;
    }

    public void setIconFlag(int iconFlag) {
        this.iconFlag = iconFlag;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", iconFlag=" + iconFlag +
                ", capital='" + capital + '\'' +
                ", square=" + square +
                '}';
    }
}
