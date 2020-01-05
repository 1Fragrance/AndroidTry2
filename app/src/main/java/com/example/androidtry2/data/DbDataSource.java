package com.example.androidtry2.data;

import com.example.androidtry2.data.repositories.ProductRepository;

// NOTE: Database data source
public class DbDataSource {

    public DbDataSource(DbContext dbContext) {
        products = new ProductRepository(dbContext);
    }

    public ProductRepository products;
}
