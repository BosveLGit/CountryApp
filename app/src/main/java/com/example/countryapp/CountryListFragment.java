package com.example.countryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountryListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountryListFragment extends Fragment {

    private OnFragmentSendDataListener fragmentSendDataListener;
    List<Country> listCountry = new ArrayList<>();

    public CountryListFragment() {
        // Required empty public constructor
    }

    interface OnFragmentSendDataListener {
        void onSendData(Country country);
    }

    public static CountryListFragment newInstance(String param1, String param2) {
        CountryListFragment fragment = new CountryListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            fragmentSendDataListener = (OnFragmentSendDataListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        ListView listView = (ListView) view.findViewById(R.id.MainListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getActivity(), listCountry);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Country selectedItem = listCountry.get(position);
                showCountryDetail(selectedItem);

            }
        });

        listView.setAdapter(customBaseAdapter);

        return view;
    }

    private void showCountryDetail(Country country) {
        MainActivity activity = (MainActivity) requireActivity();
        activity.showCountryDetail(country);
    }

}