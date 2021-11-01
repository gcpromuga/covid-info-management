package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.login.adapter.PersonInfoAdapter;
import com.example.login.object.PersonInfo;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private ListView listRecord;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initComponents();

        ArrayList<PersonInfo> arrayOfPersonInfos = new ArrayList<>();
        PersonInfoAdapter adapter = new PersonInfoAdapter(this, arrayOfPersonInfos);

        PersonInfo personInfo = new PersonInfo();
        personInfo.setFullName("Gene Romuga");
        personInfo.setAge(21);
        personInfo.setContactNo("09176123");

        PersonInfo personInfo1 = new PersonInfo();
        personInfo1.setFullName("Test Romuga");
        personInfo1.setAge(21);
        personInfo1.setContactNo("09176123");

        adapter.add(personInfo);
        adapter.add(personInfo1);

        listRecord.setAdapter(adapter);

    }

    private void initComponents() {
        listRecord = (ListView) findViewById(R.id.listViewRecord);
    }
}