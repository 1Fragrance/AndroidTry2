package com.example.androidtry2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.androidtry2.R;
import com.example.androidtry2.adapters.ProductAdapter;
import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.data.DbDataSource;
import com.example.androidtry2.models.Product;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DbDataSource db;
    private List<Product> productList;
    private ListView productListView;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        productListView = findViewById(R.id.productTableList);
        productList = new ArrayList<>();
        db = new DbDataSource(new DbContext(this));
        initializeActivityUI();
    }

    private void initializeActivityUI() {
        productList = db.products.getProducts();
        adapter = new ProductAdapter(this, R.layout.product_row, productList, db);
        productListView.setAdapter(adapter);
    }

    public void updateActivityUI() {
        productList = db.products.getProducts();
        adapter.clear();
        adapter.addAll(productList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.productTableAddButton) {
            this.startActivity(new Intent(this, ProductAddFormActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
