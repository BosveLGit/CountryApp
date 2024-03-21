package com.example.countryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyRoomDatabase database;
    CountryDAO countryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = App.getInstance().getDatabase();
        countryDAO = database.countryDAO();

        //  countryDAO.deleteAll();

        countryDAO.insert(new Country("Бельгия", "BE", "Брюссель", 30688));
        countryDAO.insert(new Country("Канада", "CA", "Оттава", 9985000));
        countryDAO.insert(new Country("Дания", "DK", "Копенгаген", 42952));
        countryDAO.insert(new Country("Эстония", "EE", "Таллин", 45339));
        countryDAO.insert(new Country("Франция", "FR", "Париж", 643801));
        countryDAO.insert(new Country("Грузия", "GE", "Тбилиси", 69700));
        countryDAO.insert(new Country("Хорватия", "HR", "Загреб", 56594));
        countryDAO.insert(new Country("Венгрия", "HU", "Будапешт", 93026));
        countryDAO.insert(new Country("Ирландия", "IE", "Дублин", 70273));
        countryDAO.insert(new Country("Япония", "JP", "Токио", 377973));

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new CountryListFragment())
                    .commit();
        }

    }

    public void showDetailFragment(Country country) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(country))
                .addToBackStack(null)
                .commit();
    }

}