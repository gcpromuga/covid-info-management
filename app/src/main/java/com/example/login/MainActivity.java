package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadDose(new String[]{"1st", "2nd"});
        loadVaccine(new String[]{"Pfizer", "Astrazeneca", "Moderna", "Sinovac", "Janssen"});
    }

    private void loadDose(String[] doses) {
        final Spinner spin = (Spinner) findViewById(R.id.spinnerDose);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, doses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    private void loadVaccine(String[] vaccines) {
        final Spinner spin = (Spinner) findViewById(R.id.spinnerVaccine);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, vaccines);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

}