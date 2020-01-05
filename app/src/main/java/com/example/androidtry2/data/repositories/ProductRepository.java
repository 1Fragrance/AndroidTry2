package com.example.androidtry2.data.repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private DbContext dbContext;
    public ProductRepository(DbContext dbContext) {
        this.dbContext = dbContext;
    }

    private String getDatabaseName() {
        return DbContext.PRODUCTS_TABLE_NAME;
    }

    public void addProduct(Product product) {
        SQLiteDatabase db = dbContext.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DbContext.PRODUCTS_NAME, product.getName());
        cv.put(DbContext.PRODUCTS_TYPE, product.getType());
        cv.put(DbContext.PRODUCTS_COST, product.getCost());

        db.insert(this.getDatabaseName(), null, cv);
        db.close();
    }

    public List<Product> getProducts() {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + this.getDatabaseName();
        Cursor cursor = db.rawQuery(selectQuery, null);

        List<Product> products = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(Integer.parseInt(cursor.getString(0)));
                product.setName(cursor.getString(1));
                product.setCost(cursor.getDouble(2));
                product.setType(cursor.getString(3));
                products.add(product);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return products;
    }

    public Product getProduct(int id) {
        SQLiteDatabase db = dbContext.getReadableDatabase();

        Cursor cursor = db.query(this.getDatabaseName(),
                new String[] { DbContext.PRODUCTS_ID, DbContext.PRODUCTS_NAME, DbContext.PRODUCTS_COST, DbContext.PRODUCTS_TYPE },
                DbContext.PRODUCTS_ID + "= ?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        Product product = new Product();
        if (cursor != null) {
            cursor.moveToFirst();

            product.setId(cursor.getInt(0));
            product.setName(cursor.getString(1));
            product.setCost(cursor.getDouble(2));
            product.setType(cursor.getString(3));

            cursor.close();
        }

        db.close();
        return product;
    }

    public void deleteProduct(int id) {
        SQLiteDatabase db = dbContext.getWritableDatabase();
        db.delete(this.getDatabaseName(), DbContext.PRODUCTS_ID + " = ?", new String[] { String.valueOf(id) });
        db.close();
    }

    public void updateProduct(Product product) {
        SQLiteDatabase db = dbContext.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DbContext.PRODUCTS_NAME, product.getName());
        cv.put(DbContext.PRODUCTS_TYPE, product.getType());
        cv.put(DbContext.PRODUCTS_COST, product.getCost());

        db.update(this.getDatabaseName(), cv, DbContext.PRODUCTS_ID + " = ?", new String[] { String.valueOf(product.getId()) });
    }
}
