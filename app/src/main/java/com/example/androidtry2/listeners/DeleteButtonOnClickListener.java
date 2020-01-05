package com.example.androidtry2.listeners;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.example.androidtry2.R;
import com.example.androidtry2.activities.MainActivity;
import com.example.androidtry2.data.DbDataSource;

// NOTE: Product row delete button listener
public class DeleteButtonOnClickListener implements View.OnClickListener {

    private MainActivity context;
    private int productId;
    private DbDataSource db;

    public DeleteButtonOnClickListener(MainActivity context, int productId, DbDataSource db) {
        this.productId = productId;
        this.context = context;
        this.db = db;
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.deleteSubmitTitle));
        builder.setPositiveButton(context.getString(R.string.deleteSubmitPositiveAnswer), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db.products.deleteProduct(productId);
                context.updateActivityUI();
            }
        });
        builder.setNegativeButton(context.getString(R.string.deleteSubmitNegativeAnswer), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

