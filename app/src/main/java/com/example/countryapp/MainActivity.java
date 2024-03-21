package com.example.countryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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