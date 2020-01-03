package com.example.androidtry2;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;

import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.data.DbDataSource;
import com.example.androidtry2.listeners.AddProductOnClickListener;


public class MainActivity extends Activity {

    DbDataSource db;
    private TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DbDataSource(new DbContext(this));
        table = findViewById(R.id.productTable);
        initializeActivityUI();
    }


    private void initializeActivityUI() {
        Button addProductBtn = findViewById(R.id.addProductButton);
        addProductBtn.setOnClickListener(new AddProductOnClickListener(db));

        Cursor productCursor = db.products.getProductsCursor();

    }
}
