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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

        countriesViewModel = new ViewModelProvider(requireActivity()).get(CountriesViewModel.class);
        detailsViewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       return inflater.inflate(R.layout.fragment_country_list, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button addbutton = view.findViewById(R.id.addButton);
        EditText nameCountry = view.findViewById(R.id.nameCountry);
        EditText capitalCountry = view.findViewById(R.id.capitaleCountry);
        EditText squareCountry = view.findViewById(R.id.squareCountry);
        EditText codeCountry = view.findViewById(R.id.codeCountry);

        ListView listView = (ListView) view.findViewById(R.id.MainListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getActivity(), listCountry);
        listView.setAdapter(customBaseAdapter);

        countriesViewModel.getCountries().observe(getViewLifecycleOwner(), new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                listCountry.clear();
                listCountry.addAll(countries);
                customBaseAdapter.setData(countries);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Country selectedItem = (Country) customBaseAdapter.getItem(position);
                detailsViewModel.setSelectedCountry(selectedItem);

                ((MainActivity) requireActivity()).showDetailFragment(selectedItem);

            }
        });

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String param_nameCountry = nameCountry.getText().toString();
                String param_capitalCountry = capitalCountry.getText().toString();
                int param_squareCountry = 0;

                try {
                    param_squareCountry = Integer.parseInt(squareCountry.getText().toString());
                } catch (NumberFormatException e) {
                }

                String param_codeCountry = codeCountry.getText().toString();

                if(param_nameCountry.isEmpty()
                        || param_capitalCountry.isEmpty()
                        || param_codeCountry.isEmpty()) {

                    Toast toast = Toast.makeText(getActivity().getApplicationContext()
                            , "Заполните навание страны, столицу и код!", Toast.LENGTH_LONG);
                    toast.show();

                    return;
                }

                Country country = new Country(param_nameCountry, param_codeCountry, param_capitalCountry, param_squareCountry);
                App.getInstance().getDatabase().countryDAO().insert(country);

                countriesViewModel.loadCountries();

                Toast toast = Toast.makeText(getActivity().getApplicationContext()
                        , "Добавлено!", Toast.LENGTH_LONG);
                toast.show();

                nameCountry.setText("");
                capitalCountry.setText("");
                squareCountry.setText("");
                codeCountry.setText("");

            }
        });

    }

}