package com.example.countryapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailFragment extends Fragment {

    DetailsViewModel viewModel;
    private TextView nameTextView;
    private TextView capitalTextView;
    private ImageView flagIcon;
    private TextView square;
    private Button buttonClose;

    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(Country country) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
     //   viewModel = new ViewModelProvider(requireActivity()).get(DetailsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_details, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameTextView = view.findViewById(R.id.nameCountry);
        capitalTextView = view.findViewById(R.id.nameCapital);
        flagIcon = view.findViewById(R.id.flagIcon);
        square = view.findViewById(R.id.square);
        buttonClose = view.findViewById(R.id.buttonClose);


        // Почему мы тут не можем получить страну и обновить данные?
        Log.d("my", viewModel.getSelectedCountry().toString());

        viewModel.getSelectedCountry().observe(getViewLifecycleOwner(), new Observer<Country>() {
            @Override
            public void onChanged(Country country) {

                Log.d("my", country.toString());

                if (country != null) {
                    displayCountryDetails(country);
                }
            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

    }

    private void displayCountryDetails(Country country) {
        if (country != null) {
            nameTextView.setText(country.getCountry());
            capitalTextView.setText(country.getCapital());
            flagIcon.setImageResource(country.getIconFlag());
            NumberFormat formatter = NumberFormat.getInstance(new Locale("RU"));
            String countrySquare = formatter.format(country.getSquare());
            square.setText(countrySquare);
        }
    }

}