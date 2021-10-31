package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewActivity extends AppCompatActivity {

    private ListView listRecord;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initComponents();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_record, R.id.textViewFullName, countryList);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.list_view_record, R.id.textViewAge, countryList);
        listRecord.setAdapter(arrayAdapter1);
        listRecord.setAdapter(arrayAdapter);
    }

    private void initComponents() {
        listRecord = (ListView) findViewById(R.id.listViewRecord);
    }
}