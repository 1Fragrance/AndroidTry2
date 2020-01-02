package com.example.androidtry2.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidtry2.R;
import com.example.androidtry2.data.repositories.ProductRepository;

public class DbContext extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public ProductRepository products;

    public DbContext(Context context) {
        super(context, context.getResources().getString(R.string.db_name), null, DATABASE_VERSION);
        products = new ProductRepository(this);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String initializeScript = "CREATE TABLE IF NOT EXISTS products ( " +
                                  "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                  "name TEXT, " +
                                  "cost REAL, " +
                                  "typeId INTEGER);";
        db.execSQL(initializeScript);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String downScript = "DROP TABLE IF EXISTS products";
        db.execSQL(downScript);
        onCreate(db);
    }
}
