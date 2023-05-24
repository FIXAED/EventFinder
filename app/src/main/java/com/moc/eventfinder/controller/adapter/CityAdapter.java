package com.moc.eventfinder.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.moc.eventfinder.model.DTO.City;

import java.util.ArrayList;

public class CityAdapter extends ArrayAdapter<City> {
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<City> cities;


    public CityAdapter(Context context, ArrayList<City> cities) {
        super(context, android.R.layout.simple_spinner_item, cities);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setText(getItem(position).getName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setText(getItem(position).getName());
        return view;
    }
}
