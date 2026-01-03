package com.example.deadbycards;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.database.Cursor;


public class ConnectToDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Users.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "user_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "survivor_name";
    private static final String COLUMN_IMAGE = "survivor_image";
    private static final String COLUMN_PERKONE = "perk_one";
    private static final String COLUMN_PERKTWO = "perk_two";
    private static final String COLUMN_PERKTHREE = "perk_three";
    private static final String COLUMN_PERKFOUR = "perk_four";
    private static final String COLUMN_CHECKLEVEL = "check_level";
    public ConnectToDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_IMAGE + " TEXT, " +
                COLUMN_PERKONE + " TEXT, " +
                COLUMN_PERKTWO + " TEXT, " +
                COLUMN_PERKTHREE + " TEXT, " +
                COLUMN_PERKFOUR + " TEXT," +
                COLUMN_CHECKLEVEL + " INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    void addSurvivor(String name, String image, String p1, String p2, String p3, String p4, boolean checkLevel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_IMAGE, image);
        contentValues.put(COLUMN_PERKONE, p1);
        contentValues.put(COLUMN_PERKTWO, p2);
        contentValues.put(COLUMN_PERKTHREE, p3);
        contentValues.put(COLUMN_PERKFOUR, p4);
        contentValues.put(COLUMN_CHECKLEVEL, checkLevel ? 1 : 0);
        long check = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (check == -1) {
            Toast.makeText(context, "Insert failed.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Insert was successful.", Toast.LENGTH_SHORT).show();
        }


    }

    Cursor fetchDatabase() {
        String databaseQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = null;
        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.rawQuery(databaseQuery, null);
        }
        return cursor;
    }
}
