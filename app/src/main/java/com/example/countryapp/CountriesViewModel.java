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
            loadCountries();
        }
        return countriesLiveData;
    }

    public void loadCountries() {

        List<Country> countryList = App.getInstance().getDatabase().countryDAO().getAllCountries();
        countriesLiveData.postValue(countryList);

    }

}
