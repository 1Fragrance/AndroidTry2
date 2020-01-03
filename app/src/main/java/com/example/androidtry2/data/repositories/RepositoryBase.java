package com.example.androidtry2.data.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidtry2.data.DbContext;

public abstract class RepositoryBase {
    protected DbContext dbContext;
    protected abstract String getDatabaseName();

    public RepositoryBase(DbContext dbContext) {
        this.dbContext = dbContext;
    }

    protected void save(ContentValues cv) {
        SQLiteDatabase db = dbContext.openConnection();
        // TODO: Update logic
        db.insert(getDatabaseName(), null, cv);
        dbContext.closeConnection();
    }

    protected Cursor getCursor(String[] columns, String orderBy) {
        SQLiteDatabase db = dbContext.openConnection();

        Cursor cursor = db.query(getDatabaseName(), columns, null, null, null, null, orderBy);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
