package com.example.countryapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

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

        if (getArguments() != null) {
            Country country = (Country) getArguments().getSerializable(CountryListFragment.ARG_COUNTRY_OBJECT);
            displayCountryDetails(country);
        }

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


    public void setSelectedItem(Country country) {

        View currentView = getView();

        ImageView flagIcon = (ImageView) currentView.findViewById(R.id.flagIcon);
        flagIcon.setImageResource(country.getIconFlag());

        TextView nameCountry = (TextView) currentView.findViewById(R.id.nameCountry);
        nameCountry.setText(country.getCountry());

        TextView nameCapital = (TextView) currentView.findViewById(R.id.nameCapital);
        nameCapital.setText(country.getCapital());

        TextView square = (TextView) currentView.findViewById(R.id.square);
        NumberFormat formatter = NumberFormat.getInstance(new Locale("RU"));
        String countrySquare = formatter.format(country.getSquare());
        square.setText(String.valueOf("Площадь " + countrySquare + " км2"));


        Button buttonClose = (Button) currentView.findViewById(R.id.buttonClose);

    }
}