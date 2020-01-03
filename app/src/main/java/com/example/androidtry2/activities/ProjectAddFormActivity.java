package com.example.androidtry2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtry2.R;
import com.example.androidtry2.listeners.BackButtonOnClickListener;
import com.example.androidtry2.models.Product;

public class ProjectAddFormActivity extends ProjectFormActivityBase {

    Button buttonAddProduct;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttonAddProduct = findViewById(R.id.addProductButton);
        buttonBack = findViewById(R.id.buttonBack);
        initializeActionHandlers();
    }

    protected void initializeActionHandlers() {
        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProduct();
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

        buttonBack.setOnClickListener(new BackButtonOnClickListener(this));
    }

    private void createProduct() {
        String name = productNameInput.getText().toString().trim();
        String cost = productCostInput.getText().toString().trim();
        String type = productTypeInput.getSelectedItem().toString();

        if (validateInputs(name, cost)) {
            Product product = new Product();
            product.setName(name);
            product.setCost(Double.parseDouble(cost));
            product.setType(type);
            db.products.addProduct(product);
        }
    }
}