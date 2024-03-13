package com.example.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CustomListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_item_list);
    }
}