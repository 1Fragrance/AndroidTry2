package com.example.androidtry2.listeners;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.androidtry2.R;
import com.example.androidtry2.data.DbDataSource;
import com.example.androidtry2.models.Product;

public class AddProductOnClickListener implements View.OnClickListener  {

    DbDataSource db;
    public AddProductOnClickListener(DbDataSource db) {
        this.db = db;
    }

    @Override
    public void onClick(View v) {
        Context context = v.getRootView().getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View formElementsView = inflater.inflate(R.layout.product_form, null, false);

        final EditText nameInput = formElementsView.findViewById(R.id.productNameInput);
        final EditText costInput = formElementsView.findViewById(R.id.productCostInput);
        final EditText typeInput = formElementsView.findViewById(R.id.productTypeInput);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Add product")
                .setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Product product = new Product();
                                product.name = nameInput.getText().toString();
                                product.cost = Double.parseDouble(costInput.getText().toString());
                                product.typeId = Integer.parseInt(typeInput.getText().toString());
                                db.products.addProduct(product);

                                dialog.cancel();
                            }

                        }).show();
    }
});
}
