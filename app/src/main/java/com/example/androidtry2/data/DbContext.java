package com.example.androidtry2.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidtry2.R;

public class DbContext extends SQLiteOpenHelper {

    // Tables
    public static final String PRODUCTS_TABLE_NAME = "products";
    public static final String PRODUCTS_ID = "id";
    public static final String PRODUCTS_NAME = "name";
    public static final String PRODUCTS_COST = "cost";
    public static final String PRODUCTS_TYPE = "type";

    private static final int DATABASE_VERSION = 1;

    public DbContext(Context context) {
        super(context, context.getResources().getString(R.string.db_name), null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String initializeScript = "CREATE TABLE IF NOT EXISTS " + PRODUCTS_TABLE_NAME + "( " +
                                  PRODUCTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                  PRODUCTS_NAME + " TEXT, " +
                                  PRODUCTS_COST + " REAL, " +
                                  PRODUCTS_TYPE + " TEXT);";
        db.execSQL(initializeScript);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String downScript = "DROP TABLE IF EXISTS products";
        db.execSQL(downScript);
        onCreate(db);
    }
}
