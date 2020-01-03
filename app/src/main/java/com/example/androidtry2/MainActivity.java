package com.example.androidtry2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.data.DbDataSource;


public class MainActivity extends Activity {

    DbDataSource db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DbDataSource(new DbContext(this));
        initializeActivityUI();
    }


    private void initializeActivityUI() {
        Button addProductBtn = findViewById(R.id.addProductButton);
    }
}
