package com.example.countryapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailsViewModel extends ViewModel {

    private MutableLiveData<Country> selectedCountryLiveData = new MutableLiveData<>();

    public LiveData<Country> getSelectedCountry() {
        return selectedCountryLiveData;
    }

    public void setSelectedCountry(Country country) {
        selectedCountryLiveData.setValue(country);
    }

}
