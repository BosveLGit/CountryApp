package com.example.countryapp;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static App instance;
    private MyRoomDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, MyRoomDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }
    public MyRoomDatabase getDatabase() {
        return database;
    }


}
