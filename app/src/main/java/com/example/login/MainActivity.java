package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerDose;
    private Spinner spinnerVaccine;
    private Button buttonSave;
    private Button buttonView;

    DBManager dbManager;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize components
        initComponents();

        // Load initial data
        loadDose(new String[]{"1st", "2nd"});
        loadVaccine(new String[]{"Pfizer", "Astrazeneca", "Moderna", "Sinovac", "Janssen"});

        // Initialize DB Manager
        initDb();

        // Save data
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager.insert("Gene",12,"1st", "Pfizer");
            }
        });

        // View records
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Cursor cursor = dbManager.fetch();
//                if (cursor.moveToFirst()) {
//                    do {
//                        @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(dbHelper.COL_ID));
//                        @SuppressLint("Range") String fullName = cursor.getString(cursor.getColumnIndex(dbHelper.COL_FULL_NAME));
//                        @SuppressLint("Range") String age = cursor.getString(cursor.getColumnIndex(dbHelper.COL_AGE));
//                        // @SuppressLint("Range") String contactNo = cursor.getString(cursor.getColumnIndex(dbHelper.COL));
//                        Log.i("INFO ID", id+" "+fullName+" "+age);
//
//                    } while (cursor.moveToNext());
//                }
                Intent viewIntent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(viewIntent);

            }
        });
    }

    private void initDb() {
        dbManager = new DBManager(this);
        try {
            dbManager.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        spinnerDose = (Spinner) findViewById(R.id.spinnerDose);
        spinnerVaccine = (Spinner) findViewById(R.id.spinnerVaccine);
        buttonSave = (Button) findViewById(R.id.btnSave);
        buttonView = (Button)  findViewById(R.id.btnView);
    }

    private void loadDose(String[] doses) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, doses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDose.setAdapter(adapter);
    }

    private void loadVaccine(String[] vaccines) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, vaccines);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVaccine.setAdapter(adapter);
    }

}