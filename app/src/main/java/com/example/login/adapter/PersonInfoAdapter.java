package com.example.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.login.R;
import com.example.login.object.PersonInfo;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PersonInfoAdapter extends ArrayAdapter<PersonInfo> {

    private TextView textFullName;
    private TextView textAge;
    private TextView textContact;
    private TextView textEmail;
    private TextView textDose;
    private TextView textVaccine;

    public PersonInfoAdapter(Context context, ArrayList<PersonInfo> personInfos) {
        super(context, 0, personInfos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PersonInfo personInfo = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_record, parent, false);
        }

        textFullName = (TextView) convertView.findViewById(R.id.textViewFullName);
        textAge = (TextView) convertView.findViewById(R.id.textViewAge);
        textContact = (TextView) convertView.findViewById(R.id.textViewContact);
        textEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        textDose = (TextView) convertView.findViewById(R.id.textViewDose);
        textVaccine = (TextView) convertView.findViewById(R.id.textViewVaccine);

        textFullName.setText(personInfo.getFullName());
        textAge.setText(String.valueOf(personInfo.getAge()));
        textContact.setText(personInfo.getContactNo());
        textEmail.setText(personInfo.getEmail());
        textDose.setText(personInfo.getDose());
        textVaccine.setText(personInfo.getVaccine());

        return convertView;
    }

}
