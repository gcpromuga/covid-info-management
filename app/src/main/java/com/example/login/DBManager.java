package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

    public void insert(String full_name, String age, String contact, String email, String dose, String vaccine) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBHelper.COL_FULL_NAME, full_name);
            contentValues.put(DBHelper.COL_AGE, age);
            contentValues.put(DBHelper.COL_CONTACT, contact);
            contentValues.put(DBHelper.COL_EMAIL, email);
            contentValues.put(DBHelper.COL_DOSE, dose);
            contentValues.put(DBHelper.COL_VACCINE, vaccine);
            database.insert(DBHelper.DB_TABLE, null, contentValues);
            Log.i("INFO", full_name);
        } catch (Exception e) {
            Log.e("ERROR",e.getMessage());
        }
    }

    public Cursor fetch() {
        String [] columns  = new String[] {DBHelper.COL_ID, DBHelper.COL_FULL_NAME, DBHelper.COL_AGE, DBHelper.COL_CONTACT, DBHelper.COL_EMAIL, DBHelper.COL_DOSE, DBHelper.COL_VACCINE};
        Cursor cursor = database.query(DBHelper.DB_TABLE, columns, null, null,  null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}
