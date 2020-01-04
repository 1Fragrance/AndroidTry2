package com.example.androidtry2.listeners;

import android.content.Intent;
import android.view.View;

import com.example.androidtry2.activities.MainActivity;
import com.example.androidtry2.activities.ProductEditFormActivity;
import com.example.androidtry2.data.DbContext;

public class EditButtonOnClickListener implements View.OnClickListener {

    private MainActivity context;
    private int productId;

    public EditButtonOnClickListener(MainActivity context, int productId) {
        this.productId = productId;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, ProductEditFormActivity.class);
        intent.putExtra(DbContext.PRODUCTS_ID, productId);
        context.startActivity(intent);
    }
}
