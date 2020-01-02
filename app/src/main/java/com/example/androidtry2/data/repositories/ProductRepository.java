package com.example.androidtry2.data.repositories;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.models.Product;

public class ProductRepository  {

    private DbContext dbContext;

    public ProductRepository(DbContext dbContext) {
        this.dbContext = dbContext;
    }

    public long add(Product product) {

        ContentValues cv = new ContentValues();
        cv.put("name", product.name);
        cv.put("typeId", product.typeId);
        cv.put("cost", product.cost);

        SQLiteDatabase db = dbContext.getWritableDatabase();
        long productId = db.insert("products", null, cv);
        db.close();

        return productId;
    }
}
