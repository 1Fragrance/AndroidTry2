package com.example.androidtry2.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.androidtry2.R;
import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.data.DbDataSource;

public abstract class ProductFormActivityBase extends Activity {

    protected DbDataSource db;
    protected EditText productNameInput;
    protected EditText productCostInput;
    protected Spinner productTypeInput;

    protected abstract void initializeActionHandlers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_form);

        db = new DbDataSource(new DbContext(this));
    }

    protected String getNameValue()
    {
        return productNameInput.getText().toString().trim();
    }

    protected String getCostValue()
    {
        return productCostInput.getText().toString().trim();
    }

    protected String getTypeValue()
    {
        return productTypeInput.getSelectedItem().toString();
    }

    protected boolean validateInputs() {
        if (getNameValue().isEmpty()) {
            productNameInput.setError(getString(R.string.nameValidationMessage));
            productNameInput.requestFocus();
            return false;
        }

        if (getCostValue().isEmpty() || Double.parseDouble(getCostValue()) < 0) {
            productCostInput.setError(getString(R.string.costValidationMessage));
            productCostInput.requestFocus();
            return false;
        }

        return true;
    }
}
