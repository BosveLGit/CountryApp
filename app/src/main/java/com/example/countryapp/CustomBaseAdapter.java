package com.example.countryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    List<Country> listCountry;
    LayoutInflater inflater;

    public CustomBaseAdapter(Context context, List<Country> listCountry) {
        this.context = context;
        this.listCountry = listCountry;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listCountry.size();
    }

    @Override
    public Object getItem(int position) {
        return listCountry.get(position);
       // return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.country_item_list, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.flagIcon);
        Country thisCountry = listCountry.get(position);
        textView.setText(thisCountry.getCountry());
    //    imageView.setImageResource(listCountry.get(position).getIconFlag());
        Glide.with(convertView).load("https://flagsapi.com/"+thisCountry.getCode()+"/shiny/64.png").into(imageView);

        return convertView;
    }

    public void setData(List<Country> countries) {
        this.listCountry.clear();
        if (countries != null) {
            this.listCountry.addAll(countries);
        }
        notifyDataSetChanged();
    }

}
