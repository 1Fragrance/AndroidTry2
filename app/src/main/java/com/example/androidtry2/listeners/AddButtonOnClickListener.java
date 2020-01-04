package com.example.androidtry2.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.androidtry2.activities.ProductAddFormActivity;

public class AddButtonOnClickListener implements View.OnClickListener {

    private Activity activity;

    public AddButtonOnClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        activity.startActivity(new Intent(activity, ProductAddFormActivity.class));
    }
}