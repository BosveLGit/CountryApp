package com.example.countryapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CountriesViewModel extends ViewModel {

    private MutableLiveData<List<Country>> countriesLiveData;

    public LiveData<List<Country>> getCountries() {
        if (countriesLiveData == null) {
            countriesLiveData = new MutableLiveData<>();
            loadCountries(); // Инициализация списка стран
        }
        return countriesLiveData;
    }

    public void loadCountries() {

        List<Country> listCountry = new ArrayList<>();

        listCountry.add(new Country("Бельгия", R.drawable.be, "Брюссель", 30688));
        listCountry.add(new Country("Канада", R.drawable.ca, "Оттава", 9985000));
        listCountry.add(new Country("Дания", R.drawable.dk, "Копенгаген", 42952));
        listCountry.add(new Country("Эстония", R.drawable.ee, "Таллин", 45339));
        listCountry.add(new Country("Франция", R.drawable.fr, "Париж", 643801));
        listCountry.add(new Country("Грузия", R.drawable.ge, "Тбилиси", 69700));
        listCountry.add(new Country("Хорватия", R.drawable.hr, "Загреб", 56594));
        listCountry.add(new Country("Венгрия", R.drawable.hu, "Будапешт", 93026));
        listCountry.add(new Country("Ирландия", R.drawable.ie, "Дублин", 70273));
        listCountry.add(new Country("Япония", R.drawable.jp, "Токио", 377973));

        countriesLiveData.setValue(listCountry);

    }

}
