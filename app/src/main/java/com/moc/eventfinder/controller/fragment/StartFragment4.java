package com.moc.eventfinder.controller.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.moc.eventfinder.R;
import com.moc.eventfinder.controller.activity.MainActivity;
import com.moc.eventfinder.controller.activity.SplashScreenActivity;
import com.moc.eventfinder.controller.adapter.CityAdapter;
import com.moc.eventfinder.model.DTO.City;
import com.moc.eventfinder.service.NetworkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartFragment4 extends Fragment {

    private CityAdapter adapter;
    private Spinner spinner;
    SharedPreferences prefs;
    private String SAVED_CITY = "CITY";
    private String FLAG = "FLAG";
    private Button next;
    private List<City> cities;
    public static final String APP_PREFERENCES = "APP_PREFERENCES";
    public String selectedItem;
    public static String slug;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        prefs = getActivity().getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_start4, container, false);
        SplashScreenActivity splashScreenActivity = new SplashScreenActivity();
        spinner = (Spinner) view.findViewById(R.id.spinner);
        next = (Button) view.findViewById(R.id.next);


        NetworkService.getInstance()
                .getJSONApi()
                .getCities()
                .enqueue(new Callback<List<City>>() {
                    @Override
                    public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                        cities = response.body();
                        List<String> cityNames = new ArrayList<>();
                        for (City city : cities) {
                            cityNames.add(city.getName());
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                                android.R.layout.simple_spinner_item, cityNames);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<City>> call, Throwable t) {
                        Toast.makeText(
                                getContext(),
                                getString(R.string.connection_problems),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                String choose = (String) spinner.getSelectedItem();
                slug = cities.get(selectedItemPosition).getSlug();
                Toast.makeText(getContext(), "Ваш выбор: " + choose, Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
//                Toast.makeText(getContext(), String.valueOf(splashScreenActivity.loadData()), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        return view;
    }

//    public void saveData() {
//        prefs = getActivity().getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putString(SAVED_CITY, selectedItem);
//        editor.putBoolean(FLAG, true);
//
//        editor.apply();
//    }
}