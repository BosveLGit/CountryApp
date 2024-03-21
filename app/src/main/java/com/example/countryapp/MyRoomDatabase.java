package com.example.countryapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Country.class}, version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {

    public abstract CountryDAO countryDAO();

}
