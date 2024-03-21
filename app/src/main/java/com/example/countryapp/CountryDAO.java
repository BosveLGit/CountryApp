package com.example.countryapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Upsert;

import java.util.List;

@Dao
public interface CountryDAO {

    @Query("SELECT * FROM Country")
    public List<Country> getAllCountries();

    @Upsert
    void insert(Country country);

    @Query("DELETE FROM Country")
    void deleteAll();

    @Delete
    void delete(Country country);

}
