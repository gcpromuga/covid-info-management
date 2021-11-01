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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editFullName;
    private EditText editAge;
    private EditText editContact;
    private EditText editEmail;
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

        // Init DB
        initDb();

        // Load initial data
        loadDose(new String[]{"1st", "2nd"});
        loadVaccine(new String[]{"Pfizer", "Astrazeneca", "Moderna", "Sinovac", "Janssen"});

        // Save data
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = editFullName.getText().toString();
                String age = editAge.getText().toString();
                String contact = editContact.getText().toString();
                String email = editEmail.getText().toString();
                String dose = spinnerDose.getSelectedItem().toString();
                String vaccine = spinnerVaccine.getSelectedItem().toString();

                if (fullName.isEmpty()) {
                    showMessage("Please enter your full name");
                    return;
                }

                if (age.isEmpty()) {
                    showMessage("Please enter your age");
                    return;
                }

                if (contact.isEmpty()) {
                    showMessage("Please enter your contact");
                    return;
                }

                if (email.isEmpty()) {
                    showMessage("Please enter your email");
                    return;
                }

                if (dose.isEmpty()) {
                    showMessage("Please select your dose");
                    return;
                }

                if (vaccine.isEmpty()) {
                    showMessage("Please select your vaccine");
                    return;
                }

                dbManager.insert(fullName,age,contact,email,dose,vaccine);
                showMessage("Successfully saved the record!");
                resetComponents();
            }
        });

        // View records
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(viewIntent);
            }
        });
    }

    private void initComponents() {
        editFullName = (EditText) findViewById(R.id.editFullName);
        editAge = (EditText) findViewById(R.id.editAge);
        editContact = (EditText) findViewById(R.id.editContactNo);
        editEmail = (EditText) findViewById(R.id.editEmail);
        spinnerDose = (Spinner) findViewById(R.id.spinnerDose);
        spinnerVaccine = (Spinner) findViewById(R.id.spinnerVaccine);
        buttonSave = (Button) findViewById(R.id.btnSave);
        buttonView = (Button)  findViewById(R.id.btnView);
    }

    private void initDb() {
        dbManager = new DBManager(this);
        try {
            dbManager.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void showMessage(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void resetComponents() {
       editFullName.setText("");
       editAge.setText("");
       editContact.setText("");
       editEmail.setText("");
       spinnerDose.setSelection(0);
       spinnerVaccine.setSelection(0);
    }


}