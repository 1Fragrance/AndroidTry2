package com.example.androidtry2.data;

import com.example.androidtry2.data.repositories.ProductRepository;

public class DbDataSource {

    public DbDataSource(DbContext dbContext) {
        products = new ProductRepository(dbContext);
    }

    public ProductRepository products;
}
