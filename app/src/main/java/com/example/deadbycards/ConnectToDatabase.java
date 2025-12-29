package com.example.deadbycards;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class ConnectToDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Users.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "survivor_name";
    private static final String COLUMN_IMAGE = "survivor_image"; // Added image column based on previous context
    private static final String COLUMN_PERKONE = "perk_one";
    private static final String COLUMN_PERKTWO = "perk_two";
    private static final String COLUMN_PERKTHREE = "perk_three";
    private static final String COLUMN_PERKFOUR = "perk_four";
    public ConnectToDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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
                COLUMN_PERKFOUR + " TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    void addSurvivor() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // contentValues()
    }
}
