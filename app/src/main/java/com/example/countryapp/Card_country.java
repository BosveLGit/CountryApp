package com.example.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Card_country extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_country);

        Bundle arguments = this.getIntent().getExtras();
        Country country;

        if(arguments != null) {

            country = (Country) arguments.getSerializable(Country.class.getSimpleName());

            ImageView flagIcon = (ImageView) findViewById(R.id.flagIcon);
        //    flagIcon.setImageResource(country.getIconFlag());
            Glide.with(this).load("https://flagsapi.com/"+country.getCode()+"/shiny/64.png").into(flagIcon);

            TextView nameCountry = (TextView) findViewById(R.id.nameCountry);
            nameCountry.setText(country.getCountry());

            TextView nameCapital = (TextView) findViewById(R.id.nameCapital);
            nameCapital.setText(country.getCapital());

            TextView square = (TextView) findViewById(R.id.square);
            NumberFormat formatter = NumberFormat.getInstance(new Locale("RU"));
            String countrySquare = formatter.format(country.getSquare());
            square.setText(String.valueOf("Площадь " + countrySquare + " км2"));

        }

        Button buttonClose = (Button) findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Card_country.this.finish();
            }
        });


    }
}