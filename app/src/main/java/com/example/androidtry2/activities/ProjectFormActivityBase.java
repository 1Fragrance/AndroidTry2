package com.example.androidtry2.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.androidtry2.R;
import com.example.androidtry2.data.DbContext;
import com.example.androidtry2.data.DbDataSource;

public abstract class ProjectFormActivityBase extends Activity {

    DbDataSource db;
    EditText productNameInput;
    EditText productCostInput;
    Spinner productTypeInput;

    protected abstract void initializeActionHandlers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productNameInput = findViewById(R.id.productNameInput);
        productCostInput = findViewById(R.id.productCostInput);
        productTypeInput = findViewById(R.id.productTypeInput);

        db = new DbDataSource(new DbContext(this));
    }

    protected boolean validateInputs(String name, String cost) {
        if (name.isEmpty()) {
            productNameInput.setError(getString(R.string.nameValidationMessage));
            productNameInput.requestFocus();
            return false;
        }

        if (cost.isEmpty() || Double.parseDouble(cost) < 0) {
            productCostInput.setError(getString(R.string.costValidationMessage));
            productCostInput.requestFocus();
            return false;
        }

        return true;
    }
}
