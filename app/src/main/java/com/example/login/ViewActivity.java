package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.login.adapter.PersonInfoAdapter;
import com.example.login.object.PersonInfo;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    DBManager dbManager;
    DBHelper dbHelper;
    private ListView listRecord;
    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand","India", "China", "australia", "Portugle", "America", "NewZealand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initComponents();
        initDb();
        fetchData();

    }

    private void initComponents() {
        listRecord = (ListView) findViewById(R.id.listViewRecord);
    }

    private void initDb() {
        dbManager = new DBManager(this);
        try {
            dbManager.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchData() {

        ArrayList<PersonInfo> arrayOfPersonInfos = new ArrayList<>();
        PersonInfoAdapter adapter = new PersonInfoAdapter(this, arrayOfPersonInfos);
        Cursor cursor = dbManager.fetch();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(dbHelper.COL_ID));
                @SuppressLint("Range") String fullName = cursor.getString(cursor.getColumnIndex(dbHelper.COL_FULL_NAME));
                @SuppressLint("Range") String age = cursor.getString(cursor.getColumnIndex(dbHelper.COL_AGE));
                @SuppressLint("Range") String contact = cursor.getString(cursor.getColumnIndex(dbHelper.COL_CONTACT));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(dbHelper.COL_EMAIL));
                @SuppressLint("Range") String dose = cursor.getString(cursor.getColumnIndex(dbHelper.COL_DOSE));
                @SuppressLint("Range") String vaccine = cursor.getString(cursor.getColumnIndex(dbHelper.COL_VACCINE));

                PersonInfo personInfo = new PersonInfo();
                personInfo.setFullName(fullName);
                personInfo.setAge(age);
                personInfo.setContactNo(contact);
                personInfo.setEmail(email);
                personInfo.setDose(dose);
                personInfo.setVaccine(vaccine);
                adapter.add(personInfo);
                listRecord.setAdapter(adapter);
            } while (cursor.moveToNext());

        }
    }

}