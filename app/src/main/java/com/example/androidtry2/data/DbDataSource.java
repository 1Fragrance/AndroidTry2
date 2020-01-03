package com.example.androidtry2.data;

import com.example.androidtry2.data.repositories.ProductRepository;

public class DbDataSource {

    protected DbContext dbContext;

    public DbDataSource(DbContext dbContext) {
        this.dbContext = dbContext;
    }

    public ProductRepository products = new ProductRepository(dbContext);
}
