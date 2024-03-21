package com.example.countryapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity
public class Country implements Serializable {

    @NotNull
    @PrimaryKey
    private String code;

    @NotNull
    private String country;

    @NotNull
    private String capital;

    @NotNull
    private int square;

    public Country(String country, String code, String capital, int square) {
        this.country = country;
        this.capital = capital;
        this.square = square;
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", code=" + code +
                ", capital='" + capital + '\'' +
                ", square=" + square +
                '}';
    }
}
