package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {

    String[] countries = new String[]{"Russia","Ukraine","UK","Germany","US","China"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView countriesRecyclerView = findViewById(R.id.countries_r_view);
        CountriesAdapter adapter = new CountriesAdapter(countries);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        countriesRecyclerView.setLayoutManager(layoutManager);
        countriesRecyclerView.setAdapter(adapter);
    }
}