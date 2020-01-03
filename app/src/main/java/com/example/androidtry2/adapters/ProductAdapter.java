package com.example.androidtry2.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidtry2.R;
import com.example.androidtry2.data.DbDataSource;
import com.example.androidtry2.listeners.EditButtonOnClickListener;
import com.example.androidtry2.models.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Activity context;
    private List<Product> products;
    private DbDataSource db;

    public ProductAdapter(Activity context, int listLayoutId, List<Product> products, DbDataSource db) {
        super(context, listLayoutId, products);

        this.context = context;
        this.products = products;
        this.db = db;
    }

    public static class ViewHolder
    {
        TextView productIdTextView;
        TextView productNameTextView;
        TextView productCostTextView;
        TextView productTypeTextView;
        Button deleteBtn;
        Button editBtn;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder vh;

        if (convertView == null) {
            vh = new ViewHolder();
            row = inflater.inflate(R.layout.product_row, null, true);

            vh.productIdTextView = row.findViewById(R.id.productIdTextView);
            vh.productNameTextView = row.findViewById(R.id.productNameTextView);
            vh.productCostTextView = row.findViewById(R.id.productCostTextView);
            vh.productTypeTextView = row.findViewById(R.id.productTypeTextView);
            vh.deleteBtn = row.findViewById(R.id.buttonDeleteProduct);
            vh.editBtn = row.findViewById(R.id.buttonEditProduct);
            row.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.productIdTextView.setText(products.get(position).getId());
        vh.productNameTextView.setText(products.get(position).getName());
        vh.productCostTextView.setText(Double.toString(products.get(position).getCost()));
        vh.productTypeTextView.setText(products.get(position).getType());

        vh.editBtn.setOnClickListener(new EditButtonOnClickListener(context, products.get(position).getId()));

        vh.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return row;
    }
}
