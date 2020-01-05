package com.example.androidtry2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtry2.R;
import com.example.androidtry2.listeners.BackButtonOnClickListener;
import com.example.androidtry2.models.Product;

import static com.example.androidtry2.R.id.addFormIncludedLayout;

public class ProductAddFormActivity extends ProductFormActivityBase {

    private Button buttonAddProduct;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_add_form);
        findViewById(addFormIncludedLayout).setVisibility(View.VISIBLE);

        productNameInput = findViewById(addFormIncludedLayout).findViewById(R.id.formNameInput);
        productCostInput = findViewById(addFormIncludedLayout).findViewById(R.id.formCostInput);
        productTypeInput = findViewById(addFormIncludedLayout).findViewById(R.id.formTypeInput);

        buttonAddProduct = findViewById(R.id.addFormSubmitButton);
        buttonBack = findViewById(R.id.addFormBackButton);
        initializeActionHandlers();
    }

    protected void initializeActionHandlers() {
        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSuccess = createProduct();
                if(isSuccess) {
                    startActivity(new Intent(v.getContext(), MainActivity.class));
                }
            }
        });

        buttonBack.setOnClickListener(new BackButtonOnClickListener(this));
    }

    private boolean createProduct() {
        String name = getNameValue();
        String cost = getCostValue();
        String type = getTypeValue();

        if (validateInputs()) {
            Product product = new Product();
            product.setName(name);
            product.setCost(Double.parseDouble(cost));
            product.setType(type);
            db.products.addProduct(product);
            return true;
        }

        return false;
    }
}