package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

public class DBManager {

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context ctx) {
        context = ctx;
    }

    public DBManager open() throws SQLDataException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    private void close() {
        dbHelper.close();
    }

    private void insert (String id, String full_name, int age, int dose, String vaccine) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_FULL_NAME, full_name);
        contentValues.put(DBHelper.COL_AGE, age);
        contentValues.put(DBHelper.COL_DOSE, dose);
        contentValues.put(DBHelper.COL_VACCINE, dose);
        database.insert(DBHelper.DB_TABLE, null, contentValues);
    }

}
