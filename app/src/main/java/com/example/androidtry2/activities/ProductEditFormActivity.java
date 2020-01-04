package com.example.androidtry2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtry2.R;
import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.listeners.BackButtonOnClickListener;
import com.example.androidtry2.models.Product;

import java.util.Arrays;

import static com.example.androidtry2.R.id.editFormIncludedLayout;

public class ProductEditFormActivity extends ProductFormActivityBase {

    Button buttonEditProduct;
    Button buttonBack;
    private int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_edit_form);
        findViewById(editFormIncludedLayout).setVisibility(View.VISIBLE);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            productId = bundle.getInt(DbContext.PRODUCTS_ID);

            productNameInput = findViewById(editFormIncludedLayout).findViewById(R.id.formNameInput);
            productCostInput = findViewById(editFormIncludedLayout).findViewById(R.id.formCostInput);
            productTypeInput = findViewById(editFormIncludedLayout).findViewById(R.id.formTypeInput);

            buttonEditProduct = findViewById(R.id.editFormSubmitButton);
            buttonBack = findViewById(R.id.editFormBackButton);
            initializeActionHandlers();
            fillInformation();
        }
    }

    private void fillInformation() {
        Product product = db.products.getProduct(productId);

        productNameInput.setText(product.getName());
        productCostInput.setText(Double.toString(product.getCost()));
        String[] types = getResources().getStringArray(R.array.productTypes);
        productTypeInput.setSelection(Arrays.asList(types).indexOf(product.getType()));
    }

    protected void initializeActionHandlers() {
        buttonEditProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProduct();
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

        buttonBack.setOnClickListener(new BackButtonOnClickListener(this));
    }

    private void editProduct() {
        String name = productNameInput.getText().toString().trim();
        String cost = productCostInput.getText().toString().trim();
        String type = productTypeInput.getSelectedItem().toString();

        if (validateInputs()) {
            Product product = new Product();
            product.setId(productId);
            product.setName(name);
            product.setCost(Double.parseDouble(cost));
            product.setType(type);
            db.products.updateProduct(product);
        }
    }
}