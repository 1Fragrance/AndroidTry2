package com.example.androidtry2.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.androidtry2.activities.ProjectEditFormActivity;
import com.example.androidtry2.data.DbContext;

public class EditButtonOnClickListener implements View.OnClickListener {

    private Activity context;
    private int productId;

    public EditButtonOnClickListener(Activity context, int productId) {
        this.productId = productId;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, ProjectEditFormActivity.class);
        intent.putExtra(DbContext.PRODUCTS_ID, productId);
        context.startActivity(intent);
    }
}
