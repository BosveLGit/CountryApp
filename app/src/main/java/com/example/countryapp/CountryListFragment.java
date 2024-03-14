package com.example.countryapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CountryListFragment extends Fragment {

    CountriesViewModel countriesViewModel;
    DetailsViewModel detailsViewModel;

    List<Country> listCountry = new ArrayList<>();

    public CountryListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countriesViewModel = new ViewModelProvider(this).get(CountriesViewModel.class);
        detailsViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_country_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        countriesViewModel.getCountries().observe(getViewLifecycleOwner(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {

                ListView listView = (ListView) view.findViewById(R.id.MainListView);
                CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getActivity(), countries);
                listView.setAdapter(customBaseAdapter);

                listCountry = countries;

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Country selectedItem = listCountry.get(position);

                        showCountryDetail();
                        detailsViewModel.setSelectedCountry(selectedItem);

                    }
                });

            }
        });
    }

    private void showCountryDetail() {
        MainActivity activity = (MainActivity) requireActivity();

        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        activity.getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment)
                .addToBackStack(null)
                .commit();

    }

}