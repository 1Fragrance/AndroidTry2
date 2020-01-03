package com.example.androidtry2.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidtry2.R;
import com.example.androidtry2.adapters.ProductAdapter;
import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.data.DbDataSource;
import com.example.androidtry2.listeners.AddButtonOnClickListener;
import com.example.androidtry2.models.Product;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    DbDataSource db;
    List<Product> productList;
    ListView productListView;
    ProductAdapter adapter;
    Button addProductButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productListView = findViewById(R.id.productList);
        productList = new ArrayList<>();
        db = new DbDataSource(new DbContext(this));
        initializeActivityUI();
    }

    private void initializeActivityUI() {
        productList = db.products.getProducts();
        adapter = new ProductAdapter(this, R.layout.product_row, productList, db);
        productListView.setAdapter(adapter);

        addProductButton = findViewById(R.id.addProductButton);
        addProductButton.setOnClickListener(new AddButtonOnClickListener(this));
    }

    public void updateActivityUI() {
        productList = db.products.getProducts();
        adapter.notifyDataSetChanged();
    }
}
