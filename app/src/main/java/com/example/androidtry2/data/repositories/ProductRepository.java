package com.example.androidtry2.data.repositories;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.models.Product;

public class ProductRepository extends RepositoryBase {

    public ProductRepository(DbContext dbContext) {
        super(dbContext);
    }

    @Override
    protected String getDatabaseName() {
        return DbContext.PRODUCTS_TABLE_NAME;
    }

    public void addProduct(Product product) {
        ContentValues cv = new ContentValues();
        cv.put("name", product.name);
        cv.put("typeId", product.typeId);
        cv.put("cost", product.cost);

        this.save(cv);
    }

    public Cursor getProductsCursor() {
        String[] columns = new String[] {DbContext.PRODUCTS_ID, DbContext.PRODUCTS_NAME, DbContext.PRODUCTS_COST, DbContext.PRODUCTS_TYPEID};
        return this.getCursor(columns, DbContext.PRODUCTS_ID);
    }
}
