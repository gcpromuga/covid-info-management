package com.example.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "vaccine.db";
    static final int DB_VERSIOn = 1;

    static final String DB_TABLE = "person";
    static final String COL_ID = "id";
    static final String COL_FULL_NAME = "full_name";
    static final String COL_AGE = "age";
    static final String COL_DOSE = "dose";
    static final String COL_VACCINE = "vaccine";

    private static final String CREATE_DB_QUERY =
            "CREATE TABLE "+ DB_TABLE + "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_FULL_NAME + " TEXT NOT NULL, "
                + COL_AGE + " INTEGER NOT NULL, "
                + COL_DOSE + " INTEGER NOT NULL, "
                + COL_VACCINE + " STRING NOT NULL "
            +");";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSIOn);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DB_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE);
    }
}
