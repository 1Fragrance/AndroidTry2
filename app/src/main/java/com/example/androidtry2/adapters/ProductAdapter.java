package com.example.androidtry2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidtry2.R;
import com.example.androidtry2.activities.MainActivity;
import com.example.androidtry2.data.DbDataSource;
import com.example.androidtry2.listeners.DeleteButtonOnClickListener;
import com.example.androidtry2.listeners.EditButtonOnClickListener;
import com.example.androidtry2.models.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private MainActivity context;
    private List<Product> products;
    private DbDataSource db;

    public ProductAdapter(MainActivity context, int listLayoutId, List<Product> products, DbDataSource db) {
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
            row = inflater.inflate(R.layout.product_row, null, false);

            vh.productIdTextView = row.findViewById(R.id.productRowIdView);
            vh.productNameTextView = row.findViewById(R.id.productRowNameView);
            vh.productCostTextView = row.findViewById(R.id.productRowCostView);
            vh.productTypeTextView = row.findViewById(R.id.productRowTypeView);
            vh.deleteBtn = row.findViewById(R.id.productRowDeleteButton);
            vh.editBtn = row.findViewById(R.id.productRowEditButton);
            row.setTag(vh);

        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.productIdTextView.setText(Integer.toString(products.get(position).getId()));
        vh.productNameTextView.setText(products.get(position).getName());
        vh.productCostTextView.setText(Double.toString(products.get(position).getCost()));
        vh.productTypeTextView.setText(products.get(position).getType());

        vh.editBtn.setOnClickListener(new EditButtonOnClickListener(context, products.get(position).getId()));
        vh.deleteBtn.setOnClickListener(new DeleteButtonOnClickListener(context, products.get(position).getId(), db));

        return row;
    }
}
